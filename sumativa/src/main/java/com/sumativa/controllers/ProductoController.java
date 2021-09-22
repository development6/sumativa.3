package com.sumativa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumativa.models.Producto;
import com.sumativa.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService ps;
	
	
	@RequestMapping("")
	public String inicio(@ModelAttribute("producto") Producto producto, Model model) {
		
		List<Producto> listaProductos=ps.findAll();
		model.addAttribute("listaProductos",listaProductos);
		return "producto.jsp";
	}
	
	
	@RequestMapping(value="/insertar", method=RequestMethod.POST)
	public String insertar(@Valid @ModelAttribute("producto") Producto producto) {
		System.out.println("insertar"+producto);
		ps.insertarProducto(producto);
		return "redirect:/producto";
	}
	
	
	@RequestMapping(value="/eliminar")
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("Eliminar id: "+id);
		ps.eliminarProducto(id);
		return "redirect:/producto";
	}
	
	
	//------------------------------
	//Editar
	
	
	@RequestMapping(value="/actualizar/{id}", method=RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("Actualizar id: "+id);
		Producto producto=ps.buscarProducto(id);
		
		model.addAttribute("producto", producto);
		return "editarProducto.jsp";
	}

	@RequestMapping(value="/modificar", method=RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("producto") Producto producto) {
		System.out.println("el Id a modificar es: "+producto.getId());
		ps.modificarProducto(producto);
		return "redirect:/producto";
	}

	
	//---------------------------------------------

	
	// !!!!!!
//	@RequestMapping("listaproductos")
//	public String lista(@ModelAttribute("listaProductos") Producto producto, Model model) {
//		
//		List<Producto> listaProductos=ps.findAll();
//		model.addAttribute("listaProductos", listaProductos);
//		return "listaProducto.jsp";
//	}
	


}
