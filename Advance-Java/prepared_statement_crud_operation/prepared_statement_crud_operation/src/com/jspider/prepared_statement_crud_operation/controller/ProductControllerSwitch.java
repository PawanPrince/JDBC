package com.jspider.prepared_statement_crud_operation.controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.prepared_statement_crud_operation.dao.ProductDao;
import com.jspider.prepared_statement_crud_operation.dto.Product;

public class ProductControllerSwitch {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			
			ProductDao dao = new ProductDao();
			
			System.out.println("=========================================");
			System.out.println("1.INSERT\n2.DISPLAYALLPRODUCT\n3.UpdateProduct\n4.DeleteByPriceStoreProcedure");
			System.out.println("=========================================");

			System.out.println("Select Your Option");

			int option = scanner.nextInt();
			
			switch (option) {
			case 1: {
				System.out.println("enter product id: ");
				int id = scanner.nextInt();

				System.out.println("enter product name: ");
				String name = scanner.next();

				System.out.println("enter product color: ");
				String color = scanner.next();

				System.out.println("enter product price: ");
				double price = scanner.nextDouble();

				Product product = new Product(id, name, color, price);

				dao.saveProductDao(product);

			}
				break;
			case 2: {
				List<Product> products=dao.getAllProductDao();
				
				for (Product product : products) {
					System.out.println(product);
					System.out.println("=========================================");
				}
			}
				break;
				
			case 3: {
				
				System.out.println("enter product id to update price: ");
				int id = scanner.nextInt();
				
				System.out.println("enter new product price: ");
				double price = scanner.nextDouble();
				
				int a=dao.updateProductPriceByProductIdDao(price, id);
				
				String msg = a!=0?"data updated":"given id not found or check with you code";
				System.out.println(msg);
				System.out.println("=========================================");
			}
				break;
             
			case 4: {
				
				System.out.println("enter new product price: ");
				double price = scanner.nextDouble();
				
				int a=dao.deleteProductByPriceStoreProcedureDao(price);
				
				String msg = a!=0?"data deleted":"given Price not found or check with you code";
				System.out.println(msg);
				System.out.println("=========================================");
			}
				break;
			}
		}

	}
}
