package com.hb1;

public interface IProductDAO {
	void addProduct(Product prod);
	Product getProduct(int id);
	java.util.List<Product> getAllRecords();
	void updateProduct(int id,int qty);
	void deleteProduct(int id);
}
