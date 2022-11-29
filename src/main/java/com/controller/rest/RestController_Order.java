package com.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.entity.Account;
import com.entity.Product;
import com.entity.cart;
import com.service.Service_Order;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/orders")
public class RestController_Order {
	@Autowired private Service_Order ordertService;
	   @GetMapping()
	    public List<cart>getAll(){
	        return ordertService.findAll();
	    }
	    @GetMapping("detail/{id}")
	    public cart detail(@PathVariable("id")Long id,Model model) {
	        return ordertService.findById(id);
	    }
	@PostMapping()
	public cart create(@RequestBody JsonNode orderData) {
		return ordertService.create(orderData);
	}
	@PutMapping("/{id}")
    public cart update(@RequestBody cart cart,@PathVariable("id")String username) {
        return ordertService.update(cart);
    }
}
