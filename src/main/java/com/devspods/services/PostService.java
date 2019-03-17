package com.devspods.services;

import com.devspods.domain.Category;
import com.devspods.domain.Post;
import com.devspods.repositories.PostRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
    @Autowired
    private PostRepository postRepository;
	
    @Autowired
    private CategoryService categoryService;

    public Post save(final Post post) {
		
        Optional<Long> categoryId = Optional.ofNullable(post.getCategory().getId());
		
        if (categoryId.isPresent()) {
			
            Category category = this.categoryService.findById(categoryId.get());
            post.setCategory(category);
        }

        return this.postRepository.save(post);
    }

    public List<Post> findAll() {

        return (List<Post>) this.postRepository.findAll();
    }
}
