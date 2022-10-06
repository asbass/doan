package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Role;


@Service
public interface Service_Role {
	List<Role> findAll();
}
