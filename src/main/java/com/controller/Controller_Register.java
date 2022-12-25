package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.DAO_Account;
import com.entity.Account;
import com.entity.Authority;
import com.entity.Role;
import com.service.Service_Account;
import com.service.Service_Authority;



@Controller
public class Controller_Register {
    String tam = null;
    @Autowired
    Service_Account SV_account;
    @Autowired
    Service_Authority SV_Author;
    @Autowired
    ServletContext app;
    @Autowired
    DAO_Account daoac;
    
    @SuppressWarnings("unused")
    @RequestMapping("/register")
    public String registrator() {
        return "security/register";
    }
    
    @SuppressWarnings("unused")
	@PostMapping("/register")

    public String registrator2(Account item,Role role,Authority author,Model model,@RequestParam("images") MultipartFile image) {
        
        if(image.isEmpty()){
              model.addAttribute("message", "Vui lòng chọn file !");
          }
          else{
        		  try {
                      String filename = image.getOriginalFilename();
                      //String path = app.getRealPath("/images/"+filename);
                      File file = new File(app.getRealPath("/assets/avatar/"+filename));
                      image.transferTo(file);
                      
                      item.setPhoto(filename);
                      item.setDatecreate(new Date());
                      item.setStatus(true);
                      
                      author.setAccount(item);
                      
                      role.setId("CUST");
                      role.setName("Customer");
                      author.setRole(role);
                      
                      
                      List<Account> acc = daoac.findAll();
                      acc.forEach(oldUsername ->{
                    	 if(oldUsername.getUsername().equals(item.getUsername()) || oldUsername.getEmail().equals(item.getEmail())) {
                    		 tam = item.getUsername();           		 
                    	 }
                      });
                      
                      if(tam != null) {
                     		model.addAttribute("message","Tên tài khoản hoặc email đã tồn tại");
tam= null;
                  	 }
                  	 else {
                   		SV_account.create(item);
//                     	System.out.println(item.getEmail());
                   		SV_Author.create(author);
                        model.addAttribute("message","Đăng ký thành công");
                   	  }   
                       
                      
                  } 
                  catch (Exception e) {
                      model.addAttribute("message", "Lỗi lưu file !");
                      System.out.println(e);
                      
                  }
        	  }
        	  
          
        return "security/register";
    }
    
}