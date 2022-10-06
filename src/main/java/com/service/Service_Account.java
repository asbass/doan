package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.account;



@Service
public interface Service_Account {
	account findById(String username);

	List<account> getAdministrators();

	List<account> findAll();

	account create(account account);

	account update(account account);

	Long getTotalAccount();

	List<Object[]> top10Customer();
}
