package com.jspider.prepared_statement_crud_operation.controller;

import com.jspider.prepared_statement_crud_operation.dao.ProductDao;
import com.jspider.prepared_statement_crud_operation.dto.Product;

public class ProductController {

	public static void main(String[] args) {
		
		System.out.println("main method execution started");
		
		ProductDao dao = new ProductDao();
		
		Product product = new Product(554433, "pendrive", "red", 350);
		
		dao.saveProductDao(product);
		
		System.out.println("main method execution ended");
		
	}
}
