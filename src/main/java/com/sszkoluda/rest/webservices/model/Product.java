package com.sszkoluda.rest.webservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "name")
	private String name;
	@Column(name = "cost")
	private Double cost;
	@Column(name = "type")
	private String type;
	@Column(name = "shop")
	private String shop;
	@Column(name = "list_name_in_product")
	private String listNameInProduct;
	
	public Product() {
		
	}
	
	public Product(String name, double cost, String type, String shop) {
		this.name = name;
		this.cost = cost;
		this.type = type;
		this.shop = shop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public Integer getProductId() {
		return productId;
	}
	public String getListNameInProduct() {
		return listNameInProduct;
	}
	public void setListNameInProduct(String listNameInProduct) {
		this.listNameInProduct = listNameInProduct;
	}
	
	
	
	
}
