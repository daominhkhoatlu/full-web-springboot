package com.spring.khoa.fullspringweb.service;

import com.spring.khoa.fullspringweb.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void saveProduct(Product product);
    Product getProductById(Integer id) throws RuntimeException;
    void deleteProductById(Integer id);
}
