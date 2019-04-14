package com.devspods.repositories;

import com.devspods.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository {

    @Query("SELECT post FROM Post post " +
           "JOIN FETCH post.category " +
           "JOIN FETCH post.status " +
           "JOIN FETCH post.postDetail " +
           "JOIN FETCH post.authors aut " +
           "JOIN FETCH aut.gender " +
           "JOIN FETCH post.technicalReviewers revs " +
           "JOIN FETCH revs.gender"
    )
    List<Post> findAll();
}