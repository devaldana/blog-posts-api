package com.devspods.services.impl;

import com.devspods.domain.Author;
import com.devspods.domain.Post;
import com.devspods.exceptions.RequiredAttributeNotFoundException;
import com.devspods.projections.PostBasicInfo;
import com.devspods.repositories.PostRepository;
import com.devspods.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.devspods.util.helpers.PostServiceHelper.convertFromPostToPostBasicInfo;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Post save(final Post post) throws RequiredAttributeNotFoundException {
        validateRequiredAttributes(post);
        return this.postRepository.save(post);
    }

    @Override
    public PostBasicInfo saveAndGetBasicInfo(final Post post) {
        Post savedPost = save(post);
        return convertFromPostToPostBasicInfo(savedPost);
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
            post.getStatus().getId() == null) throw new RequiredAttributeNotFoundException("Category or PostStatus was not founded");

        Optional<Author> authorWithoutId = Stream.concat(post.getAuthors().stream(), post.getTechnicalReviewers().stream())
                                                 .filter(author -> author.getId() == null)
                                                 .findFirst();

        if( authorWithoutId.isPresent() ) throw new RequiredAttributeNotFoundException("Registered author is required");
    }
}
