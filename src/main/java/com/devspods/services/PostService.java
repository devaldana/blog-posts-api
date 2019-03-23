package com.devspods.services;

import com.devspods.domain.Post;
import com.devspods.projections.PostBasicInfo;

import java.util.List;

public interface PostService extends CrudService<Post, Long> {

    List<PostBasicInfo> findPublishedPostsBasicInfo();
}
