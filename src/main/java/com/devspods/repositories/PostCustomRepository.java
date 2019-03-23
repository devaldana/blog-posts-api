package com.devspods.repositories;

import com.devspods.projections.PostBasicInfo;

import java.util.List;

public interface PostCustomRepository {

    List<PostBasicInfo> findPublishedPostsBasicInfo();
}
