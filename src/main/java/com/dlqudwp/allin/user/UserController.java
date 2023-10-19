package com.dlqudwp.allin.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/user/login")
	public String Userlogin() {
		return "/user/login";
	}

}
