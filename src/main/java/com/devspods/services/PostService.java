package com.devspods.services;

import com.devspods.domain.Post;

public interface PostService extends CrudService<Post, Long> {

    String findPostsBasicInfo();
}
