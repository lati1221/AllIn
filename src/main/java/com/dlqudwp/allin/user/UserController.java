package com.dlqudwp.allin.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/user/login")
	public String Userlogin() {
		
		return "/user/login";
	}
	
	@GetMapping("/user/join")
	public String Userjoin() {
		
		return "/user/join";
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		return "redirect:/mainmenu/mainpage-view";
		
		
	}

}
