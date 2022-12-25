package com.service;

import org.springframework.stereotype.Service;

import com.entity.TongTien;
import com.entity.dtn;

@Service
public interface Service_OrderDetail {
	TongTien sum(); 
	dtn tongngay();
	
}
