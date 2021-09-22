package com.sumativa.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sumativa.models.Usuario;
import com.sumativa.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository ur;
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.ur=usuarioRepository;
	}

	public Usuario insertarUsuario(@Valid Usuario usuario) {
		return ur.save(usuario);
	}
	
	public List<Usuario> findAll() {
		return ur.findAll();
	}

	public void eliminarUsuario(Long id) {
		ur.deleteById(id);
	}

	//Si lo encuentra retorna -----
	//Si no lo encuentra retorna ......
	public boolean verificarUsuario(String email, String contrasena){
		List<Usuario> usuarios=ur.findAll();
		for(int i=0;i<usuarios.size();i++){
			if(email.equals(usuarios.get(i).getEmail())){
				if(contrasena.equals(usuarios.get(i).getContrasena())){
						return true;
				}
				return false;
			}
		}
		return false;
	}
	
	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> oUsuario=ur.findById(id);
		if(oUsuario.isPresent()) {
			return oUsuario.get();
		}

		return null;
	}

	public void modificarUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		ur.save(usuario);
	}

}
