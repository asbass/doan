package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "accounts")
public class Account  implements Serializable{
	@Id
	String username;
	String password;
	String fullname;
	String email;
	String photo;
	Boolean sex;
	@Temporal(TemporalType.DATE)
	@Column(name = "createdate")//nếu tên 2 chữ thì phải viết thường mới map được vs bên CSDL
	Date createDate = new Date();
	Boolean status;
	@Temporal(TemporalType.DATE)
	@Column(name = "datebirth")//nếu tên 2 chữ thì phải viết thường mới map được vs bên CSDL
	Date datebirth = new Date();
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<cart> cart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;
}
