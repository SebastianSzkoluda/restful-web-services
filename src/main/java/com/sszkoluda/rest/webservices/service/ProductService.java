package com.sszkoluda.rest.webservices.service;

import com.sszkoluda.rest.webservices.model.Product;

public interface ProductService {

	Iterable<Product> listAllProducts();
	void saveProduct(Product product);
	void deleteProduct(Integer id);
	//List<Product> getProductsForCurrentList(String listName);
	Product getCurrentProduct(Integer id);
	Product addProductToCurrentList(Product product, String listName);
	void updateProduct(Integer id,Product product);
}
