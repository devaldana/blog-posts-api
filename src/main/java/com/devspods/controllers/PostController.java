package com.devspods.controllers;

import com.devspods.domain.Post;
import com.devspods.services.PostService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
	
    @Autowired
    private PostService postService;
	
    @PostMapping
    public ResponseEntity<Post> save(@RequestBody @NotNull @Valid final Post post) {

        final Post savedPost = this.postService.save(post);
        return ResponseEntity.ok(savedPost);
    }

    @GetMapping
    public List<Post> findAll() {

        return this.postService.findAll();
    }
}
