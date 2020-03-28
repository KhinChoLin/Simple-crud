package com.simple.crud.simplecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple.crud.simplecrud.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
