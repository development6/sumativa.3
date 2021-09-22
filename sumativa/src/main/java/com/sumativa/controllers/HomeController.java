package com.sumativa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumativa.models.Usuario;

@Controller
public class HomeController {

//	@RequestMapping("/")
//	public String inicio(Model model) {
//		model.addAttribute("usuario", new Usuario());
//		return "login.jsp";
//	}
	
	@RequestMapping("/")
	public String pagina() {
		return "login2.jsp";
	}
	
}
