package com.sszkoluda.rest.webservices.service;

import com.sszkoluda.rest.webservices.model.ProductList;

public interface ProductListService {

	ProductList saveProductList(String listName);
	ProductList getProductsList(String listName);
	void deleteProductList(Integer id);
}
