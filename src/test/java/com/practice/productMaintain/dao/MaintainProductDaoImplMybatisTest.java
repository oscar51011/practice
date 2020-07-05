package com.practice.productMaintain.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.practice.PracticeApplication;
import com.practice.productMaintain.model.ProductModel;

/**
 * 測試過程不能讓 db 真實寫入資料 @Transactional & @Rollback (預設為 true)
 * 要來預防上述事件發生，如果把 rollback 改成 @Rollback(false)，就不具備 測試完自動 rollBack的行為
 * @author 林聖凱
 *
 */
@SpringBootTest(classes = {PracticeApplication.class})
@Transactional
class MaintainProductDaoImplMybatisTest {

	@Autowired
	private MaintainProductDaoImplMybatis dao;
	
	/**
	 * 測試商品資料是否正確寫入
	 * 有寫入後撈出來比對是否一致後
	 * 即 Rollback 避免影響 db 資料
	 */
	@Test
	@Rollback
	void saveProduct_SkuNameIsEqual() {
		
		String expected = "測試商品3";
		
		ProductModel product = new ProductModel();
		product.setSkuNumber("test3");
		product.setSkuName("測試商品3");
		
		dao.saveProduct(product);
		ProductModel actualProductModel = dao.getProductBySkuNumber("test3");
		String actual = actualProductModel.getSkuName();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * 不管 Db 是否有資料，只是測試查詢行為是否正常可連接資料庫
	 * 所以只有不拋錯誤訊息，就算查到 0 筆資料 也算查詢完成
	 */
	@Test
	void testGetProductBySkuNumber() {
		assertDoesNotThrow(
				() -> dao.getProductBySkuNumber("test")
		);
	}
	
	/**
	 * 新增一筆資料，並修改它，驗證修改後的值是否正確
	 */
	@Test
	@Rollback
	void updateProudct_SkuNameHasChanged() {
		
		String expected = "測試商品change";
		
		ProductModel product = new ProductModel();
		product.setSkuNumber("test3");
		product.setSkuName("測試商品3");		
		dao.saveProduct(product);
		
		ProductModel needUpdateProduct = dao.getProductBySkuNumber("test3");
		needUpdateProduct.setSkuName("測試商品change");
		
		int count = dao.updateProudct(needUpdateProduct);
		assertEquals(count, 1);	//驗證改變是否為一筆
		
		ProductModel updatedProduct = dao.getProductBySkuNumber("test3");
		String actual = updatedProduct.getSkuName();
		
		assertEquals(expected, actual);	//驗證改變的 skuName是否符合預期
	}
	
	/**
	 * 先建立一個商品，驗證是否刪除
	 */
	@Test
	@Rollback
	void deleteProduct_deleteSuccess() {
		
		ProductModel product = new ProductModel();
		product.setSkuNumber("test3");
		product.setSkuName("測試商品3");		
		dao.saveProduct(product);
		
		ProductModel insertedProduct = dao.getProductBySkuNumber("test3");
		int productId = insertedProduct.getProductId();
		assertNotNull(productId);// 驗證 測試商品是否正確寫入
		
		dao.deleteProduct(productId);
		
		ProductModel deletedProduct = dao.getProductBySkuNumber("test3");
		assertNull(deletedProduct);// 已刪除資料，驗證是否已查詢不到資料				
	}

}
