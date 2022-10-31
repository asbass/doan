package com.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.entity.Account;

import com.service.Service_Account;


@CrossOrigin("*")
@RestController
@RequestMapping("rest/register")
public class RestController_Register {
	@Autowired private Service_Account accountService;
	boolean status = true;
	@PostMapping()
	public Account create(@RequestBody Account account) {
        return accountService.create(account);
    }
	

}
