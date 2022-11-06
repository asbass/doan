package com.controller;

import java.io.File;
import java.util.Date;

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
import com.service.Service_Account;
import com.service.Service_Authority;



@Controller
public class Controller_Register {
	
	@Autowired
	Service_Account ad;
	@Autowired
	Service_Authority au;
	@Autowired
    ServletContext app;
	
	@SuppressWarnings("unused")
    @RequestMapping("/register")
	public String registrator() {
		return "security/register";
	}
	
	@PostMapping("/register")
	public String registrator2(Account item,Model model,@RequestParam("images") MultipartFile image, Authority auth) {
        /*
         * a.setPhoto("user.png");
         * ad.save(a);
         * ra.addAttribute("message", "Thanh Cong");
         */
	    if(image.isEmpty()){
            model.addAttribute("message", "Vui lòng chọn file !");
        }
        else{
            try {
                String filename = image.getOriginalFilename();
//                String path = app.getRealPath("/images/"+filename);
                File file = new File(app.getRealPath("/images/"+filename));
                image.transferTo(file);
                ad.create(item);
               
                au.create(auth);
                model.addAttribute("message","Đăng ký thành công");
                return "redirect:/register";
            } 
            catch (Exception e) {
                
                model.addAttribute("message", "Đăng ký không thành công! Vui lòng kiểm tra lại thông tin");
                
            }
        }
		return "redirect:/register";
	}
	
}
