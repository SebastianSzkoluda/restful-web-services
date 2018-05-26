package com.sszkoluda.rest.webservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sszkoluda.rest.webservices.model.ProductList;
import com.sszkoluda.rest.webservices.repository.ProductListRepository;
import com.sszkoluda.rest.webservices.service.ProductListService;
import com.sszkoluda.rest.webservices.service.ProductService;

@Service
public class ProductListServiceImpl implements ProductListService {

	
	
	@Autowired
	ProductListRepository productListRepository;
	
	@Autowired 
	ProductService productService;
	
	@Override
	public ProductList saveProductList(String listName) {
		ProductList productList;
		productList = new ProductList(listName);
		productListRepository.save(productList);	
		return productList;
	}

	@Override
	public ProductList getProductsList(String listName) {
		
		ProductList productList;
		productList = productListRepository.findByName(listName);
		
		
		return productList;
	}

	@Override
	public void deleteProductList(Integer id) {
		ProductList productList;
		productList = productListRepository.findListById(id);
		productListRepository.delete(productList);
		
	}


}
