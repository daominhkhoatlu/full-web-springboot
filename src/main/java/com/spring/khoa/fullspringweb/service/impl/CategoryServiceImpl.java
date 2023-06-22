package com.spring.khoa.fullspringweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.khoa.fullspringweb.model.Category;
import com.spring.khoa.fullspringweb.repository.CategoryRepository;
import com.spring.khoa.fullspringweb.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public void saveCategory(Category category) {
		this.categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(Integer id) throws RuntimeException {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
		return category;
	}

	@Override
	public void deleteCategoryById(Integer id) {
		this.categoryRepository.deleteById(id);
	}

}
