package com.sumativa.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sumativa.models.Producto;
import com.sumativa.repositories.ProductoRepository;

@Service
public class ProductoService {

	private final ProductoRepository pr;
	public ProductoService(ProductoRepository productoRepository) {
		this.pr=productoRepository;
	}
	
	
	
	
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}


	public Producto insertarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		return pr.save(producto);
	}


	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}




	
	public Producto buscarProducto(Long id) {
		Optional<Producto> oProducto=pr.findById(id);
		if(oProducto.isPresent()) {
			return oProducto.get();
		}
		return null;
	}


	public void modificarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		pr.save(producto);
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
