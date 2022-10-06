package com.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.account;
import com.service.Service_Account;

@CrossOrigin("*")
@RestController
@RequestMapping("rest")
public class RestController_Account {
	@Autowired private Service_Account accountService;
	
	@GetMapping("accounts")
	public List<account>getAccounts(@RequestParam("admin")Optional <Boolean>admin){
		if(admin.orElse(false)) {
			return accountService.getAdministrators();
		}
		return accountService.findAll();
	}
	
	@PostMapping("accountsManage")
	public account create(@RequestBody account account) {
		return accountService.create(account);
	}
	
	@PutMapping("accounts/{id}")
	public account update(@RequestBody account account,@PathVariable("id")String username) {
		return accountService.update(account);
	}
}
