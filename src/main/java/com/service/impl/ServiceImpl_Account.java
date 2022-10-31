package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DAO_Account;
import com.entity.Account;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.Service_Account;

@Service
public class ServiceImpl_Account implements Service_Account{
	@Autowired private DAO_Account accDao;

	@Override
	public Account findById(String username) {
		return accDao.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		return accDao.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		return accDao.findAll();
	}

	@Override
	public Account create(Account account) {
		return accDao.save(account);
	}

	@Override
	public Account update(Account account) {
		return accDao.save(account);
	}
	/*Summary*/

	@Override
	public Long getTotalAccount() {
		return accDao.count();
	}

    @Override
    public Account add(JsonNode accountData) {
        ObjectMapper mapper = new ObjectMapper();
        
        Account account = mapper.convertValue(accountData, Account.class);
        accDao.save(account);
        
        return account;
    }

 


    /*
     * @Override
     * public List<Object[]> top10Customer() {
     * return accDao.top10Customer();
     * }
     */

	
}
