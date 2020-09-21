// ajax upload excel file
// Reference: https://ithelp.ithome.com.tw/articles/10196021
$(document).on("click","#fileUploadBtn", function (e) {
	
		console.log("123")

    	alert("start");
    	
        // cancel the default behavior
        e.preventDefault();
        
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
                console.log(res);
                
                var titles = res.titles;
                for(i=0;i<titles.size;i++){
                	console.log(titles[i])
                }
                
                //console.log('title數量' + res.titles[].length);
                
            },
            error: function (err) {
                console.error(err);
            }
        });
});
