package com.sumativa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumativa.services.VentaService;

@Controller
public class VentaController {

	private final VentaService vs;
	public VentaController(VentaService ventaService) {
		this.vs=ventaService;
	}
	
	@RequestMapping("")
	public String inicio() {
		return null;
	}
	
	@RequestMapping("/insertar")
	public String insertar() {
		return null;
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar() {
		return null;
	}
	
	
	
	@RequestMapping("/actualizar")
	public String actualizar() {
		return null;
	}
	
	@RequestMapping("/modificar")
	public String modificar() {
		return null;
	}
	
	
	
}
