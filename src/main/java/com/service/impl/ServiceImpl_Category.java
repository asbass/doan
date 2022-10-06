package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DAO_Category;
import com.entity.Category;
import com.service.Service_Category;

@Service
public class ServiceImpl_Category implements Service_Category{
	@Autowired private DAO_Category cateDao;

	@Override
	public List<Category> findAll() {
		return cateDao.findAll();
	}
}
