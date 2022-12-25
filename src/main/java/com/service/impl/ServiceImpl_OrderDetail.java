package com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DAO_OrderDetail;
import com.entity.TongTien;
import com.entity.dtn;
import com.util.XDate;
import com.service.Service_OrderDetail;

@Service
public class ServiceImpl_OrderDetail implements Service_OrderDetail{

	@Autowired private DAO_OrderDetail ss;
	@Autowired private XDate xdate;
	
    @Override
    public Double getTodayIncome() {
        return ss.findAll().stream().filter(e->e.getCart().getCreateDate().toString().equals(xdate.convertToPattern(new Date(), "yyyy-MM-dd"))).mapToDouble(item->item.getPrice()*item.getQuantity()).sum();
    }
    @Override
    public Double getTotalIncome() {
        return ss.findAll().stream().mapToDouble(item->item.getPrice()*item.getQuantity()).sum();
    }
	@Override
	public TongTien sum() {
		return ss.sum();
	}
	@Override
	public dtn tongngay() {
		System.out.println("sdasd");
		if(ss.tongngay() != null){
			System.out.println("sdasd");
			return ss.tongngay();
		}else{
			dtn dtn = new dtn();
			dtn.setTttn(0);
			System.out.println(dtn);
			return dtn ;
		}
	}
}
