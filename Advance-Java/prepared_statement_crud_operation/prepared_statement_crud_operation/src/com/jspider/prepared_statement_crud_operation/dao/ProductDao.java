package com.jspider.prepared_statement_crud_operation.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jspider.prepared_statement_crud_operation.connection.ProductConnection;
import com.jspider.prepared_statement_crud_operation.dto.Product;


public class ProductDao {

	Connection connection = ProductConnection.getProductConnection();

	public void saveProductDao(Product p) {
		System.out.println("saveProductDao method execution started");
		String insertProductQuery = "insert into product(id,name,color,price) values(?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(insertProductQuery);

			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getColor());
			ps.setDouble(4, p.getPrice());

			int a = ps.executeUpdate();

			String msg = a != 0 ? "data stored" : "something went wrong";

			System.out.println(msg);
			System.out.println("saveProductDao method execution ended");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("saveProductDao method execution ended");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Product getProductByIdDao(int productId) {
		String displayProductByIdQuery = "Select * from product where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(displayProductByIdQuery);
			ps.setInt(1, productId);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String color = set.getString("color");
				double price = set.getDouble("price");
				Product product = new Product(id, name, color, price);
				return product;
			} else {
				System.out.println("given id is not found!!!!");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> getAllProductDao() {
		String displayAllProductQuery = "Select * from product";
		try {
			PreparedStatement ps = connection.prepareStatement(displayAllProductQuery);
			ResultSet set = ps.executeQuery();
			List<Product> products = new ArrayList<Product>();
			while (set.next()) {

				int id = set.getInt("id");
				String name = set.getString("name");
				String color = set.getString("color");
				double price = set.getDouble("price");

				Product product = new Product(id, name, color, price);

				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int updateProductPriceByProductIdDao(double price, int id) {

		String updateProductPriceQuery = "update product set price=? where id=?";

		try {

			PreparedStatement ps = connection.prepareStatement(updateProductPriceQuery);
			ps.setDouble(1, price);
			ps.setInt(2, id);

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteProductByIdDao(int id) {

		String deleteProductQuery = "delete from product where id=?";

		try {

			PreparedStatement ps = connection.prepareStatement(deleteProductQuery);
			ps.setInt(1, id);

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteProductByPriceStoreProcedureDao(double price) {



		try {

			CallableStatement cs = connection.prepareCall("call deleteProductByPrice(?)");
			cs.setDouble(1, price);

			return cs.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
