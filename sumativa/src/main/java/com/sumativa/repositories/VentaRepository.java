package com.sumativa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sumativa.models.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

}
