package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.cart;
import com.fasterxml.jackson.databind.JsonNode;


@Service
public interface Service_Order {
	cart create(JsonNode orderData);

	cart findById(Long id);

	List<cart> findByUsername(String username);

	Long getToDayOrder();

	Long totalOrder();

	List<Object[]> getRevenueLast7Days();
}
