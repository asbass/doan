package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.entity.Products;

public interface Service_Product{

	Page<Products> findAll(Pageable pageable);
	
	Page<Products> findByCategoryID(String cid,Pageable pageable);
	
	List<Products> findAll();

	Products findById(Integer productID);

	List<Products> findByCategoryID(String cid);

	Products create(Products products);

	Products update(Products products);

	void delete(Integer id);

	Long getAvailable();

	Long getTotalProduct();

	List<Object[]> numberOfProductSoldByType();

	List<Object[]> getPercentByCate();

	List<Object[]> availableRate();

	List<Object[]> top10Product();
	
	List<Products> findByKeywords(String keywords);

}
