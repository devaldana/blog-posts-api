package com.devspods.services;

import com.devspods.domain.Category;
import com.devspods.repositories.CategoryRepository;
import java.util.function.Supplier;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(final Long id) {
		
        return this.categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found with the provided ID"));
    }
}