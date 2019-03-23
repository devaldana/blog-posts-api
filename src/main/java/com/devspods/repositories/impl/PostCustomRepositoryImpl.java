package com.devspods.repositories.impl;

import com.devspods.projections.PostBasicInfo;
import com.devspods.repositories.PostCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PostCustomRepositoryImpl implements PostCustomRepository {

    //TODO Should CriteriaBuilder be used to construct queries?
    private static final String QUERY_FIND_POSTS_BASIC_INFO = "SELECT new com.devspods.projections.PostBasicInfo(" +
                                                              "post.id, post.title, post.dateOfPublication, post.dateOfLastUpdate, post.excerpt, cat.name, pstat.name) " +
                                                              "FROM Post post " +
                                                              "JOIN post.category cat " +
                                                              "JOIN post.status pstat";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PostBasicInfo> findPublishedPostsBasicInfo() {

        return entityManager.createQuery(QUERY_FIND_POSTS_BASIC_INFO).getResultList();
    }
}
