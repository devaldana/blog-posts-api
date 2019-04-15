package com.devspods.util.helpers;

import com.devspods.domain.Post;
import com.devspods.projections.PostBasicInfo;

public final class PostServiceHelper {

    public static PostBasicInfo convertFromPostToPostBasicInfo(Post post) {
        return new PostBasicInfo(post.getId(), post.getTitle(), post.getDateOfCreation());
    }
}
