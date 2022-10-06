package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DAO_Account;
import com.entity.account;
import com.service.Service_Account;

@Service
public class ServiceImpl_Account implements Service_Account{
	@Autowired private DAO_Account accDao;

	@Override
	public account findById(String username) {
		return accDao.findById(username).get();
	}

	@Override
	public List<account> getAdministrators() {
		return accDao.getAdministrators();
	}

	@Override
	public List<account> findAll() {
		return accDao.findAll();
	}

	@Override
	public account create(account account) {
		return accDao.save(account);
	}

	@Override
	public account update(account account) {
		return accDao.save(account);
	}
	/*Summary*/

	@Override
	public Long getTotalAccount() {
		return accDao.count();
	}

	@Override
	public List<Object[]> top10Customer() {
		return accDao.top10Customer();
	}

	
}
