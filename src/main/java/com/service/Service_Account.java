package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Account;
import com.fasterxml.jackson.databind.JsonNode;



@Service
public interface Service_Account {
	Account findById(String username);

	List<Account> getAdministrators();

	List<Account> findAll();

	Account add(JsonNode accountData);
	
	Account create(Account account);


	Account update(Account account);

	Long getTotalAccount();

    /* List<Object[]> top10Customer(); */
}
