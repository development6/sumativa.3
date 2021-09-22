package com.sumativa.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import com.sumativa.models.Resumen;
import com.sumativa.services.ProductoService;
import com.sumativa.services.ResumenService;


@Controller
@RequestMapping("/resumen")
public class ResumenController {

	//depen
	@Autowired
	private ResumenService rs;
	
	@Autowired
	private ProductoService ps;
	
	
	
	@RequestMapping("")
	public String inicio(@ModelAttribute("resumen") Resumen resumen, Model model) {
		
		List<Resumen> listaResumens=rs.findAll();
		model.addAttribute("listaResumenes", listaResumens);
		return "resumen.jsp";
	}
	
	
	@RequestMapping(value="/insertar", method=RequestMethod.POST)
	public String insertar(@Valid @ModelAttribute("resumen") Resumen resumen) {
		System.out.println("insertar"+resumen);
		rs.insertarResumen(resumen);
		return "redirect:/resumen";
	}
	
	
	@RequestMapping(value="/eliminar")
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("Eliminar id: "+id);
		rs.eliminarResumen(id);
		return "redirect:/resumen";
	}
	
	
//	@RequestMapping(value="/actualizar/{id}", method=RequestMethod.GET)
//	public String actualizar(@PathVariable("id") Long id, Model model) {
//		System.out.println("Actualizar id: "+id);
//		Resumen resumen=rs.buscarResumen(id);
//		
//		model.addAttribute("resumen", resumen);
//		return "editarResumen.jsp";
//	}
//
//	@RequestMapping(value="/modificar", method=RequestMethod.PUT)
//	public String modificar(@Valid @ModelAttribute("resumen") Resumen resumen) {
//		System.out.println("el Id a modificar es: "+resumen.getId());
//		rs.modificarResumen(resumen);
//		return "redirect:/resumen";
//	}
	
	
	//-----------------------------------------
	
//	//buscar id en producto y luego agregar a la nueva lista
//		@RequestMapping(value="/buscar/{id}", method=RequestMethod.GET)
//	    public String buscar(@PathVariable("id") Long id, Model model){
//	        System.out.println("Actualizar id: "+id);
//	        Producto producto = ps.buscarProducto(id);
//	       
//	        model.addAttribute("producto", producto);
//	        List<Producto> listaCarrito= new ArrayList<Producto>();
//	        //cs.agregar(producto);
//	        //System.out.println("Aqui: "+producto.getNombre());
//	        listaCarrito.add(producto);
//	        System.out.println(listaCarrito);
//	        
//	        model.addAttribute("listaCarrito", listaCarrito);
//	        
//	        return "redirect:/producto";
//	       
//	    }
//		
//		@RequestMapping("/ingresar")
//		public String ingresar(@RequestParam("email") String email,
//				@RequestParam("password") String password,
//				HttpSession session
//				) {
//			boolean exiteUsuario = userService.validarUser(email, password);
//			if(exiteUsuario) {
//				User user = userService.findByEmail(email);
//				//guardando un elemento en session
//				session.setAttribute("userId", user.getId());
//				return "home.jsp";
//			}
//			
//			return "redirect:/login";
//		}
//		
//		@RequestMapping("/registrar")
//		public String registrar(@Valid @ModelAttribute("user") User user) {
//			//llamar a las validaciones
//			userService.save(user);
//			return "login.jsp";
//		}


	@RequestMapping("listaproductos")
	public String lista(@ModelAttribute("listaProductos") Producto producto, Model model) {
		
		List<Producto> listaProductos=ps.findAll();
		model.addAttribute("listaProductos", listaProductos);
		return "listaProducto.jsp";
	}
	
	
	
	@RequestMapping(value="/buscarP/{id}", method = RequestMethod.GET)
	public String buscarP(@PathVariable("id") Long id, Model model) {
		Producto producto=ps.buscarProducto(id);
		
		model.addAttribute("producto", producto);
		System.out.println(producto);
		return "resumen.jsp";
	}
	
	@RequestMapping(value="/ingresarP")
	public String ingresarP(@ModelAttribute("producto") Resumen resumen) {
		rs.agregarProducto(resumen);
		return "resumen.jsp";
	}
	
	
}
