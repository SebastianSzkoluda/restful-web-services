package com.sszkoluda.rest.webservices.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sszkoluda.rest.webservices.model.Product;
import com.sszkoluda.rest.webservices.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired 
	ProductService productService;
	
	@GetMapping(path = "/product")
	Product getProduct(@RequestParam(value = "id",required = true) Integer id) {
		
		Product product = productService.getCurrentProduct(id);
		
		return product;
		
	}
	
	@PostMapping(path = "/product")
	public ResponseEntity<Object> addNewProductToCurrentList(@RequestBody Product product, @RequestParam(value = "listName",required = true) String listName){
		
		Product savedProduct;
		savedProduct = productService.addProductToCurrentList(product, listName);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}")
				.buildAndExpand(savedProduct.getProductId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path = "/product{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
	}
	
	@PutMapping(path = "/product{id}")
	public void updateProduct(@PathVariable Integer id, @RequestBody Product product ) {
	
		productService.updateProduct(id, product);
	}
	
	
}
