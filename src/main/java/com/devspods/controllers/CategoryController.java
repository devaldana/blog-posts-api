package com.devspods.controllers;

import com.devspods.domain.Category;
import com.devspods.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> findAll() {

        return (List<Category>) this.categoryRepository.findAll();
    }
}