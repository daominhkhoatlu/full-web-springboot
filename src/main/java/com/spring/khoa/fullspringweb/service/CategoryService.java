package com.spring.khoa.fullspringweb.service;

import java.util.List;

import com.spring.khoa.fullspringweb.model.Category;

public interface CategoryService {
	List<Category> getAllCategory();
    void saveCategory(Category category);
    Category getCategoryById(Integer id) throws RuntimeException;
    void deleteCategoryById(Integer id);
}
