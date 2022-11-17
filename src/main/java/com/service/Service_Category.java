package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.entity.Product;

@Service
public interface Service_Category {

	List<Category> findAll();
	Page<Category> findAll(Pageable pageable);
	Category findById(String cateID);
	Category create(Category cate);

	Category update(Category cate);

    void delete(String id);
}
