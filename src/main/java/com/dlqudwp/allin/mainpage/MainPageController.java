package com.dlqudwp.allin.mainpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mainmenu")
@Controller
public class MainPageController {
	
	@GetMapping("/mainpage-view")
	public String Mainpage() {
		return "/main/mainpage";
	}
	
	@GetMapping("/product")
	public String ProductManage() {
		return "/product/product";
	}
	
	

}
