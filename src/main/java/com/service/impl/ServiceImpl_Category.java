package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dao.DAO_Category;
import com.entity.Category;
import com.entity.Product;
import com.service.Service_Category;

@Service
public class ServiceImpl_Category implements Service_Category{
	@Autowired private DAO_Category cateDao;

	@Override
	public List<Category> findAll() {
		return cateDao.findAll();
	}
	   @Override
	    public Page<Category> findAll(Pageable pageable) {
	        return cateDao.findAll(pageable);
	    }
	@Override
    public Category findById(String cateID) {
        return cateDao.findById(cateID).get();
    }

    
    @Override
    public Category create(Category cate) {
        return cateDao.save(cate);
    }

    @Override
    public Category update(Category cate) {
        return cateDao.save(cate);
    }

    @Override
    public void delete(String id) {
        cateDao.deleteById(id);
    }

}
