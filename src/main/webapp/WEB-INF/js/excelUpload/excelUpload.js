// ajax upload excel file
// Reference: https://ithelp.ithome.com.tw/articles/10196021
$(document).on("click","#fileUploadBtn", function (e) {
	    	
        // cancel the default behavior
        e.preventDefault();
                
        validateExcelFileInput();
                       
        // file upload
        var form = $('#file-upload-form')[0];
        var formData = new FormData(form);
        
        // use $.ajax() to upload file
        $.ajax({
            url: "/uploadExcel/uploadExcelAction",
            type: "POST",
            data: formData,
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            success: function (res) {
            	
            	// TODO: response 回傳如何處理取值
            	var jsonData = JSON.parse(res);

                
            },
            error: function (err) {
                console.error(err);
            }
        });
});


/**
 * input 基本資料檢核
 */
var validateExcelFileInput = function(){
	var excelFile = $('#uploadfile').val();
		
	// check Excel File is not empty
	if(excelFile == ""){
		alert("檔案不得為空!");
		return false;
	}
	
	// check File Extension is true format
	var validExts = new Array(".xls", ".xlsx");
	var fileExtension = excelFile.substring(excelFile.lastIndexOf('.'));
	if(validExts.indexOf(fileExtension) < 0){
		 alert("檔案類型錯誤，可接受的副檔名有：" + validExts.toString());
		 return false;
	} 
	
	
}
