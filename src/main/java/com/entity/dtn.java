package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(name = "DTTN", query = "DECLARE @Oder_TN INT;SET @Oder_TN = (SELECT (sum(f.price*f.quantity))FROM Odersdetails f inner join cart c on c.id =  f.order_id where DAY(c.createDate) =  DAY(GETDATE()));IF @Oder_TN is null SET @Oder_TN = 0; ELSE SET @Oder_TN = @Oder_TN;Select @Oder_TN")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class dtn implements Serializable {
	@Id
	private int id;
	private double tttn;
	public dtn(double tttn){
		this.tttn = tttn;
	}
	
}
