package com.controller;

import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MailInfo;
import com.dao.DAO_Account;
import com.entity.Account;
import com.util.MailerService;




@Controller
public class Controller_Forget {
	
	@Autowired
	DAO_Account ad;
	@Autowired
	MailerService ms;
	
	
	@GetMapping("/forget")
	public String forget() {
		return "security/forget";
	}
	
	@PostMapping("/forget")
	public String forget2(RedirectAttributes ra, @RequestParam("email") String e) {
		Optional<Account> account = ad.findByEmail(e);
		MailInfo mail = new MailInfo(e, "LK.CAR", account.get().getPassword());
		try {
			ms.send(mail);
			ra.addAttribute("message", "Vui lòng check email để lấy lại mật khẩu");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ra.addAttribute("message", "Email này không tồn tại. Vui lòng nhập lại email");
		}
		return "redirect:/forget";
	}

}
