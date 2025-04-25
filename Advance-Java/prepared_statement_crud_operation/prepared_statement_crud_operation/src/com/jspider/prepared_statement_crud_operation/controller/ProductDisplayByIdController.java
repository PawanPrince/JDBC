package com.jspider.prepared_statement_crud_operation.controller;

import com.jspider.prepared_statement_crud_operation.dao.ProductDao;
import com.jspider.prepared_statement_crud_operation.dto.Product;

public class ProductDisplayByIdController {

	public static void main(String[] args) {
		ProductDao dao = new  ProductDao();
		
		Product product=dao.getProductByIdDao(554433);
		
		if(product!=null) {
			System.out.println(product);
		}else {
			System.out.println("given id not present");
		}
	}
}
