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

import com.entity.Category;
import com.entity.Product;
import com.service.Service_Category;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/Categories")
public class RestController_Category {
	@Autowired private Service_Category cateService;
	
	@GetMapping()
	public List<Category> getAll() {
		return cateService.findAll();
	}

    @GetMapping("{id}")
    public Category getOne(@PathVariable("id")String id) {
        return cateService.findById(id);
    }
    
    @PostMapping
    public Category create(@RequestBody Category cate) {
        return cateService.create(cate);
    }
    
    @PutMapping("{id}")
    public Category update(@RequestBody Category cate,@PathVariable("id")String id) {
        return cateService.update(cate);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")String id) {
        cateService.delete(id);
    }
}
