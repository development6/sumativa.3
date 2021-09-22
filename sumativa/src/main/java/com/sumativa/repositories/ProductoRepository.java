package com.sumativa.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sumativa.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
