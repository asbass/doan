package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.OrderDetail;
import com.entity.TongTien;
import com.entity.dtn;


@Repository
public interface DAO_OrderDetail extends JpaRepository<OrderDetail, Long>{
	@Query("SELECT new com.entity.TongTien(sum(f.price*f.quantity)) FROM OrderDetail f")
	TongTien sum();
	@Query("SELECT new com.entity.dtn(CASE WHEN sum(f.price*f.quantity) > 0 then sum(f.price*f.quantity) else '0'  end)FROM OrderDetail f  where DAY(f.cart.createDate) =  DAY(current_date())")
	dtn tongngay();
}
