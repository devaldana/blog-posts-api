package com.devspods.repositories.impl;

import com.devspods.projections.PostBasicInfo;
import com.devspods.repositories.PostCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class PostCustomRepositoryImpl implements PostCustomRepository {

    private static final String QUERY_FIND_POSTS_BASIC_INFO = "SELECT new com.devspods.projections.PostBasicInfo(" +
                                                              "post.id, post.title, post.dateOfCreation) " +
                                                              "FROM Post post";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PostBasicInfo> findPublishedPostsBasicInfo() {
        return entityManager.createQuery(QUERY_FIND_POSTS_BASIC_INFO).getResultList();
    }

    @Override
    public String findPostsBasicInfo() {

        StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery("posts_basic_info")
                                                       .registerStoredProcedureParameter("posts", String.class, ParameterMode.OUT);

        return (String) query.getOutputParameterValue("posts");
    }
}
