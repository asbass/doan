package com.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DAO_Order;
import com.dao.DAO_OrderDetail;
import com.entity.cart;
import com.entity.Account;
import com.entity.OrderDetail;
import com.service.Service_Order;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class ServiceImpl_Order implements Service_Order{

	@Autowired private DAO_Order dao;
	@Autowired private DAO_OrderDetail ddao;
	@Override
    public List<cart> findAll() {
        return dao.findAll();
    }

	@Override
	public cart create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		cart order = mapper.convertValue(orderData, cart.class);
		dao.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d->d.setCart(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		
		return order;
	}
	   public cart update(cart cart) {
	        return dao.save(cart);
	    }
	@Override
	public cart findById(Long id) {
		return dao.findById(id).get();
	}
	
	@Override
	public List<cart> findByUsername(String username) {
		return dao.findByUsername(username);
	}
	/* Summary section */
	
	@Override
	public Long getToDayOrder() {
		return dao.getTodayOrder();
	}
	@Override
	public Long totalOrder() {
		return dao.count();
	}
	@Override
	public List<Object[]> getRevenueLast7Days() {
		return dao.getRevenueLast7Days();
	}
	
}
