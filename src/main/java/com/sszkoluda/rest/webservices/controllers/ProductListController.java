package com.sszkoluda.rest.webservices.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sszkoluda.rest.webservices.model.Product;
import com.sszkoluda.rest.webservices.model.ProductList;
import com.sszkoluda.rest.webservices.repository.ProductListRepository;
import com.sszkoluda.rest.webservices.service.ProductListService;
import com.sszkoluda.rest.webservices.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductListController {
	
	Product product;
	
	@Autowired 
	ProductService productService;
	
	@Autowired 
	ProductListService productListService;
	
	@Autowired
	ProductListRepository productListRepository;
	
	
	
	@GetMapping(path = "/product-list")
	public ProductList getListOfProducts(@RequestParam String listName) {
	
		ProductList productList;
		productList = productListService.getProductsList(listName);
		
		
		return productList;		
	}
	
	@PostMapping(path = "/product-list")
	public ResponseEntity<Object> addNewListOfProducts(@RequestParam String listName) {
		
		ProductList savedProductList;
		
		savedProductList = productListService.saveProductList(listName);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
				.buildAndExpand(savedProductList.getId()).toUri();
		
		return ResponseEntity.created(location).build();		
		
	}
	@DeleteMapping("/product-list/{id}")
	public void deleteListOfProducts(@PathVariable Integer id) {
		productListService.deleteProductList(id);
				
	}


}
