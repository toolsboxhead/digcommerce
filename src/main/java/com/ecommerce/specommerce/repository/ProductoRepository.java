package com.ecommerce.specommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.ecommerce.specommerce.domain.model.Producto;


public interface ProductoRepository extends  JpaRepository<Producto,Integer>{
    
}
