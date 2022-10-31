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
import com.service.Service_Account;



@Controller
public class Controller_Register {
	
	@Autowired
	Service_Account ad;
	@Autowired
    ServletContext app;
	
	@SuppressWarnings("unused")
    @RequestMapping("/register")
	public String registrator() {
	    boolean status = true;
		return "security/register";
	}
	
//	public String registrator2(Account item,Model model,@RequestParam("images") MultipartFile image) {
//        /*
//         * a.setPhoto("user.png");
//         * ad.save(a);
//         * ra.addAttribute("message", "Thanh Cong");
//         */
//	    if(image.isEmpty()){
//            model.addAttribute("message", "Vui lòng chọn file !");
//        }
//        else{
//            try {
//                String filename = image.getOriginalFilename();
//                //String path = app.getRealPath("/images/"+filename);
//                File file = new File(app.getRealPath("/images/"+filename));
//                image.transferTo(file);
//                item.setPhoto(filename);
//                item.setDatecreate(new Date());
//                item.setStatus(true);
//                ad.create(item);
//                System.out.println(item);
//                System.out.println(model);
//                model.addAttribute("message","Đăng ký thành công");
//                return "redirect:/register";
//            } 
//            catch (Exception e) {
//                model.addAttribute("message", "Lỗi lưu file !");
//                
//            }
//        }
//		return "redirect:/register";
//	}
	
}
