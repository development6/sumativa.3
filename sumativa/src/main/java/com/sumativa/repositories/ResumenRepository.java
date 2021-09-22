package com.sumativa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumativa.models.Resumen;

@Repository
public interface ResumenRepository extends JpaRepository<Resumen, Long>{

}
