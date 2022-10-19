package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dao.DAO_Product;
import com.entity.Product;

@Controller
public class Controller_Home {
    
    @Autowired
    DAO_Product pd;
	
	@GetMapping({"","home/index"})
	public String home(Model model) {
	    List<Product> list = pd.findAll();
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
