package com.service;

import org.springframework.stereotype.Service;

import com.entity.TongTien;
import com.entity.dtn;

@Service
public interface Service_OrderDetail {

	Double getTodayIncome();

	Double getTotalIncome();
	TongTien sum(); 
	dtn tongngay();
	
}
