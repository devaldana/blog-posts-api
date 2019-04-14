package com.devspods.services.impl;

import com.devspods.domain.Author;
import com.devspods.domain.Post;
import com.devspods.exceptions.RequiredAttributeNotFoundException;
import com.devspods.repositories.PostRepository;
import com.devspods.services.CategoryService;
import com.devspods.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    public Post save(final Post post) throws RequiredAttributeNotFoundException {
        validateRequiredAttributes(post);
        setUpdatedRequiredAttributes(post);
        return this.postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {
        return this.postRepository.findById(id)
                                  .orElseThrow(() -> new EntityNotFoundException("Post not found with the given ID"));
    }

    @Override
    public void deleteById(Long id) {
        this.postRepository.deleteById(id);
    }

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public String findPostsBasicInfo() {
        return this.postRepository.findPostsBasicInfo();
    }

    private void validateRequiredAttributes(final Post post) throws RequiredAttributeNotFoundException {
        if( post.getCategory().getId() == null ||
            post.getStatus().getId() == null ||
            post.getPostDetail().getId() == null) throw new RequiredAttributeNotFoundException("Category, PostStatus or PostDetail were not founded");

        Optional<Author> authorWithoutId = post.getAuthors().stream()
                                                           .filter(author -> author.getId() == null)
                                                           .findFirst();

        if( authorWithoutId.isPresent() ) new RequiredAttributeNotFoundException("Registered author is required");
    }

    private void setUpdatedRequiredAttributes(final Post post){
        //TODO method implementation
    }
}
