package com.sumativa.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumativa.models.Producto;
import com.sumativa.models.Resumen;
import com.sumativa.repositories.ResumenRepository;

@Service
public class ResumenService {
	
	@Autowired
	private ResumenRepository rr;

	public List<Resumen> findAll() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	public Resumen insertarResumen(@Valid Resumen resumen) {
		// TODO Auto-generated method stub
		return rr.save(resumen);
	}


	public void eliminarResumen(Long id) {
		// TODO Auto-generated method stub
		rr.deleteById(id);
	}

	public Resumen buscarResumen(Long id) {
		Optional<Resumen> oResumen=rr.findById(id);
		if(oResumen.isPresent()) {
			return oResumen.get();
		}
		return null;
	}

	public void modificarResumen(@Valid Resumen resumen) {
		// TODO Auto-generated method stub
		rr.save(resumen);
	}

	public Resumen agregarProducto(Resumen resumen) {
		// TODO Auto-generated method stub
		return  rr.save(resumen);
	}

	
	
	
}
