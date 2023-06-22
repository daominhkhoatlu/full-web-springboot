package com.spring.khoa.fullspringweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.khoa.fullspringweb.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
