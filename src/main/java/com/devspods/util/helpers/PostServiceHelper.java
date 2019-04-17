package com.devspods.util.helpers;

import com.devspods.domain.Post;
import com.devspods.projections.PostBasicInfo;
import com.devspods.util.Util;

import java.util.Objects;

public final class PostServiceHelper {

    public static PostBasicInfo convertFromPostToPostBasicInfo(Post post) {
        validateParams(post);
        return new PostBasicInfo(post.getId(), post.getTitle(), post.getDateOfCreation());
    }

    private static void validateParams(Post post){
        if(Objects.isNull(post) || Util.isNull(post.getId(), post.getTitle(), post.getDateOfCreation()))
            throw new IllegalArgumentException("Invalid post or invalid post attributes");
    }
}
