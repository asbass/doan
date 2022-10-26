package com.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Products;
import com.service.Service_Product;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/products")
public class RestController_Product {
	@Autowired private Service_Product productService;
	
	@GetMapping()
	public List<Products>getAll(){
		return productService.findAll();
	}
	
	@GetMapping("{id}")
	public Products getOne(@PathVariable("id")Integer id) {
		return productService.findById(id);
	}
	
	@PostMapping
	public Products create(@RequestBody Products products) {
		return productService.create(products);
	}
	
	@PutMapping("{id}")
	public Products update(@RequestBody Products products,@PathVariable("id")Integer id) {
		return productService.update(products);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		productService.delete(id);
	}
}
