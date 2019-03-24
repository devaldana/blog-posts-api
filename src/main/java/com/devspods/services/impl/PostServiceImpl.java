package com.devspods.services.impl;

import com.devspods.domain.Category;
import com.devspods.domain.Post;
import com.devspods.repositories.PostRepository;
import com.devspods.services.CategoryService;
import com.devspods.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private CategoryService categoryService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, CategoryService categoryService){

        this.postRepository = postRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Post save(final Post post) {
		
        Optional<Long> categoryId = Optional.ofNullable(post.getCategory().getId());
		
        if (categoryId.isPresent()) {
			
            Category category = this.categoryService.findById(categoryId.get());
            post.setCategory(category);
        }

        return this.postRepository.save(post);
    }

    @Override
    public Post findById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Post> findAll() {

        this.postRepository.findPostsBasicInfo();

        return this.postRepository.findAll();
    }


    @Override
    public String findPostsBasicInfo() {

        return this.postRepository.findPostsBasicInfo();
    }
}
