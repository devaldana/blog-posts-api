package com.devspods.services;

import com.devspods.domain.Post;
import com.devspods.projections.PostBasicInfo;

public interface PostService extends CrudService<Post, Long> {

    String findPostsBasicInfo();
    PostBasicInfo saveAndGetBasicInfo(Post post);
}
