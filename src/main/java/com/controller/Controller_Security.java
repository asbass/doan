package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("security")
public class Controller_Security {
	
	@GetMapping("login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng nhập thông tin!");
		return "security/login";
	}
	
	@GetMapping("login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "security/login";
	}
	
	@GetMapping("login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập!");
		return "security/login";
	}
	
	@GetMapping("unauthorized")
	public String unauthorized(Model model) {
		model.addAttribute("message", "Không có quyền truy xuất!");
		return "security/login";
	}
	
	@GetMapping("logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Bạn đã đăng xuất!");
		return "security/login";
	}
	
//	@GetMapping("register/form")
//	public String registerForm(Model model) {
//        model.addAttribute("message", "Vui lòng nhập thông tin!");
//        return "security/register";
//    }
//	@GetMapping("register/success")
//    public String registerSuccess(Model model) {
//        model.addAttribute("message", "Đăng ký thành công!");
//        return "security/register";
//    }
//	@GetMapping("register/error")
//    public String registerError(Model model) {
//        model.addAttribute("message", "Thiếu thông tin! Đăng ký thấy bại!");
//        return "security/register";
//    }
}
