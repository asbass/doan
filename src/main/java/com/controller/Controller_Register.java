package com.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.DAO_Account;
import com.entity.Account;
import com.entity.Category;
import com.service.Service_Account;



@Controller
public class Controller_Register {
	
	@Autowired
	Service_Account ad;
	

    
    @GetMapping("register")
    public String checkout() {
        return "security/register";
    }
}
