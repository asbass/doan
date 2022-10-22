package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dao.DAO_Product;
import com.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private DAO_Product pro;

@Override
public List<Product> findByCategoryId(String cid) {
    return pro.findByCategoryId(cid);
}

@Override
public Page<Product> findByCategoryId(String cid, Pageable pageable) {
    return pro.findByCategoryId(cid, pageable);
}

@Override
public Long getAvailable() {
    return pro.getAvailable();
}

@Override
public List<Object[]> numberOfProductSoldByType() {
    return pro.numberOfProductSoldByType();
}

@Override
public <S extends Product> S save(S entity) {
    return pro.save(entity);
}

@Override
public <S extends Product> Optional<S> findOne(Example<S> example) {
    return pro.findOne(example);
}

@Override
public List<Object[]> getPercentByCate() {
    return pro.getPercentByCate();
}

@Override
public Page<Product> findAll(Pageable pageable) {
    return pro.findAll(pageable);
}

@Override
public List<Product> findAll() {
    return pro.findAll();
}

@Override
public List<Object[]> availableRate() {
    return pro.availableRate();
}

@Override
public List<Product> findAll(Sort sort) {
    return pro.findAll(sort);
}

@Override
public List<Product> findAllById(Iterable<Integer> ids) {
    return pro.findAllById(ids);
}

@Override
public Optional<Product> findById(Integer id) {
    return pro.findById(id);
}

@Override
public <S extends Product> List<S> saveAll(Iterable<S> entities) {
    return pro.saveAll(entities);
}

@Override
public void flush() {
    pro.flush();
}

@Override
public <S extends Product> S saveAndFlush(S entity) {
    return pro.saveAndFlush(entity);
}

@Override
public boolean existsById(Integer id) {
    return pro.existsById(id);
}

@Override
public List<Object[]> top10Product() {
    return pro.top10Product();
}

@Override
public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
    return pro.saveAllAndFlush(entities);
}

@Override
public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
    return pro.findAll(example, pageable);
}

@Override
public void deleteInBatch(Iterable<Product> entities) {
    pro.deleteInBatch(entities);
}

@Override
public <S extends Product> long count(Example<S> example) {
    return pro.count(example);
}

@Override
public <S extends Product> boolean exists(Example<S> example) {
    return pro.exists(example);
}

@Override
public void deleteAllInBatch(Iterable<Product> entities) {
    pro.deleteAllInBatch(entities);
}

@Override
public long count() {
    return pro.count();
}

@Override
public void deleteById(Integer id) {
    pro.deleteById(id);
}

@Override
public void deleteAllByIdInBatch(Iterable<Integer> ids) {
    pro.deleteAllByIdInBatch(ids);
}

@Override
public void delete(Product entity) {
    pro.delete(entity);
}

@Override
public void deleteAllById(Iterable<? extends Integer> ids) {
    pro.deleteAllById(ids);
}

@Override
public void deleteAllInBatch() {
    pro.deleteAllInBatch();
}

@Override
public Product getOne(Integer id) {
    return pro.getOne(id);
}

@Override
public void deleteAll(Iterable<? extends Product> entities) {
    pro.deleteAll(entities);
}

@Override
public void deleteAll() {
    pro.deleteAll();
}

@Override
public Product getById(Integer id) {
    return pro.getById(id);
}

@Override
public <S extends Product> List<S> findAll(Example<S> example) {
    return pro.findAll(example);
}

@Override
public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
    return pro.findAll(example, sort);
}

}
