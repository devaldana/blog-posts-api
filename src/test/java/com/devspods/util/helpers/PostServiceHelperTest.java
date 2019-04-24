package com.devspods.util.helpers;


import com.devspods.domain.Post;
import com.devspods.projections.PostBasicInfo;
import org.junit.jupiter.api.Test;

import static com.devspods.util.helpers.PostServiceHelper.convertFromPostToPostBasicInfo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostServiceHelperTest {

    private static final String ERROR_MSG = "Invalid post or invalid post attributes";

    @Test
    public void testConvertFromPostToPostBasicInfo() {

        Post post;
        PostBasicInfo postBasicInfo;
        String postTitle = "Lambda expressions";
        long postId = 1L;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> convertFromPostToPostBasicInfo(null));
        assertEquals(ERROR_MSG, exception.getMessage());

        post = new Post();
        assertThrows(IllegalArgumentException.class, () -> convertFromPostToPostBasicInfo(post));

        post.setId(postId);
        assertThrows(IllegalArgumentException.class, () -> convertFromPostToPostBasicInfo(post));

        post.setTitle(postTitle);
        assertDoesNotThrow(() -> convertFromPostToPostBasicInfo(post));

        postBasicInfo = convertFromPostToPostBasicInfo(post);
        assertNotNull(postBasicInfo);
        assertNotNull(postBasicInfo.getDateOfCreation());
        assertEquals(postTitle, postBasicInfo.getTitle());
        assertEquals(postId, postBasicInfo.getId());
    }
}
