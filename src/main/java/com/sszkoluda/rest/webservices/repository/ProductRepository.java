package com.sszkoluda.rest.webservices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sszkoluda.rest.webservices.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("SELECT n FROM Product n WHERE n.id LIKE :id ")
	Product findProductById(@Param("id") Integer id);
}
