package com.devspods.util.helpers;

import com.devspods.domain.Post;
import com.devspods.projections.PostBasicInfo;

public final class PostServiceHelper {

    public static PostBasicInfo convertFromPostToPostBasicInfo(final Post post) {
        return new PostBasicInfo().setId(post.getId())
                                  .setTitle(post.getTitle())
                                  .setDateOfPublication(post.getDateOfPublication())
                                  .setDateOfLastUpdate(post.getDateOfLastUpdate())
                                  .setExcerpt(post.getExcerpt())
                                  .setCategory(post.getCategory().getName())
                                  .setStatus(post.getStatus().getName());
    }
}
