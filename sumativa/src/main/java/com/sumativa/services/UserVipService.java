package com.sumativa.services;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumativa.models.UserVip;
import com.sumativa.repositories.UserVipRepository;

@Service
public class UserVipService {
	
	@Autowired
	private UserVipRepository userVipRepository;

	
	public void save(@Valid UserVip userVip) {
        String hashed = BCrypt.hashpw(userVip.getPassword(), BCrypt.gensalt());
        userVip.setPassword(hashed);
		userVipRepository.save(userVip);
	}

	public boolean validarUserVip(String email, String password) {
		
		UserVip userVip = userVipRepository.findByEmail(email);
		if(userVip == null) {
			return false;
		}else {
			if (BCrypt.checkpw(password, userVip.getPassword())) {
			    System.out.println("Password iguales");
				return true;
				
			}else {
			    System.out.println("Password Distintos");
			    return false;
			}
			
		}
	}

	public UserVip findByEmail(String email) {
		return userVipRepository.findByEmail(email);
	}
	
}
