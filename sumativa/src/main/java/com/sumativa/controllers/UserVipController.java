package com.sumativa.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumativa.models.UserVip;
import com.sumativa.services.UserVipService;

@Controller
public class UserVipController {
	
	@Autowired
	UserVipService userVipService;
	
	@RequestMapping("/login2")
	public String login() {
		return "login2.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("userVip") UserVip userVip) { 
		return "registro.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session
			) {
		boolean exiteUsuario = userVipService.validarUserVip(email, password);
		if(exiteUsuario) {
			UserVip userVip = userVipService.findByEmail(email);
			session.setAttribute("userVipId", userVip.getId());
			return "home.jsp";
		}
		
		return "redirect:/login2";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@Valid @ModelAttribute("userVip") UserVip userVip) {
		userVipService.save(userVip); 
		return "login2.jsp";
	}
	
	
	
	@RequestMapping("/home")
	public String home(HttpSession session){
		//valida el acceso a rutas
		if(session.getAttribute("userVipId")!=null) {
			return "home.jsp";
		}
		return "redirect:/login2";
		
	}
	
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		if(session.getAttribute("userVipId")!=null) {
			session.invalidate();
		}
		return "redirect:/login2";
	}

}
