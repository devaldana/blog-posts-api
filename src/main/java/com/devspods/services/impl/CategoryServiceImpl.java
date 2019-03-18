package com.devspods.services.impl;

import com.devspods.domain.Category;
import com.devspods.repositories.CategoryRepository;
import com.devspods.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
	
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){

        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category entity) {
        return null;
    }

    @Override
    public Category findById(final Long id) {
		
        return this.categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found with the provided ID"));
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) this.categoryRepository.findAll();
    }
}