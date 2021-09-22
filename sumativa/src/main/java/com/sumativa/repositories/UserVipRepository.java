package com.sumativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumativa.models.UserVip;

public interface UserVipRepository extends JpaRepository<UserVip, Long>{

	UserVip findByEmail(String email);

}
