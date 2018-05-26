package com.sszkoluda.rest.webservices.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "product_list")
public class ProductList {
	
	@Id
	@Column(name = "list_name")
	 String listName;
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listNameInProduct", orphanRemoval = true, cascade = CascadeType.ALL)
	List<Product> content;	
	
	public ProductList(){
		
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public ProductList(String listName) {
		this.listName = listName;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public List<Product> getContent() {
		return content;
	}
	public void setContent(List<Product> content) {
		this.content = content;
	}
	
	
	
}
