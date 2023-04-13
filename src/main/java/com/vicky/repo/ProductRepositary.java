package com.vicky.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicky.entity.Products;

public interface ProductRepositary extends JpaRepository<Products, Integer>{

}
