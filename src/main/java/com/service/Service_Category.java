package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Category;

@Service
public interface Service_Category {

	List<Category> findAll();

}
