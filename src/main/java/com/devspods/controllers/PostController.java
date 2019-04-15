package com.devspods.controllers;

import com.devspods.domain.Post;
import com.devspods.projections.PostBasicInfo;
import com.devspods.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/posts")
public class PostController {
	
    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }
	
    @PostMapping
    public ResponseEntity<PostBasicInfo> save(@RequestBody @NotNull @Valid Post post) {
        PostBasicInfo savedPost = postService.saveAndGetBasicInfo(post);
        return ResponseEntity.ok(savedPost);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String status) {
        String posts = postService.findPostsBasicInfo();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(posts);
    }
}
