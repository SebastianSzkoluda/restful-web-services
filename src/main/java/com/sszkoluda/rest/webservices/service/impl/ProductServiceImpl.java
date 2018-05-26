package com.sszkoluda.rest.webservices.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sszkoluda.rest.webservices.model.Product;
import com.sszkoluda.rest.webservices.model.ProductList;
import com.sszkoluda.rest.webservices.repository.ProductListRepository;
import com.sszkoluda.rest.webservices.repository.ProductRepository;
import com.sszkoluda.rest.webservices.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductListRepository productListRepository;
	
	@Override
	public Iterable<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void saveProduct(Product product) {		
		productRepository.save(product);
	}


	@Transactional
	@Override
	public Product addProductToCurrentList(Product product, String listName) {
		
		productRepository.save(product);
		ProductList productList;
		productList = productListRepository.findByName(listName);
		productList.getContent().add(product);
		
		return product;
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product getCurrentProduct(Integer id) {
		Product product = productRepository.findProductById(id);
		return product;
	}

	@Override
	public void updateProduct(Integer id, Product product) {
		Product found;
		found = productRepository.findProductById(id);
		found.setName(product.getName());
		found.setCost(product.getCost());
		found.setType(product.getType());
		found.setShop(product.getShop());		
		
		productRepository.save(found);
		
	}

}
