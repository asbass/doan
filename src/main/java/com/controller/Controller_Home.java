package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.DAO_Product;
import com.entity.Products;
import com.service.Service_Product;
import com.service.SessionService;

@Controller
public class Controller_Home {
    
    @Autowired private Service_Product daoPD;
    
    @Autowired private SessionService session;
	
    @GetMapping({"","home/index"})
	public String home(Model model) {
	    List<Products> list = daoPD.findAll();
	    if(list != null) {
	        model.addAttribute("items",list);
	    }
		return "index";
	}
	
	@GetMapping({"admin","admin/home/index"})
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}
}
