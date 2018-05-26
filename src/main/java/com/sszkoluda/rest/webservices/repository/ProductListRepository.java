package com.sszkoluda.rest.webservices.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sszkoluda.rest.webservices.model.ProductList;



public interface ProductListRepository extends CrudRepository<ProductList, Integer> {
	@Query("SELECT n FROM ProductList n WHERE n.listName LIKE :listName ")
	ProductList findByName(@Param("listName") String listName);
	
	@Query("SELECT n FROM ProductList n WHERE n.id LIKE :id ")
	ProductList findListById(@Param("id") Integer id);
}
