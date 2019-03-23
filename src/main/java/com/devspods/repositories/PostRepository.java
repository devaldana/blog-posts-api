package com.devspods.repositories;

import com.devspods.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>, PostCustomRepository {

    @Query("SELECT post FROM Post post JOIN FETCH post.category JOIN FETCH post.status")
    List<Post> findAll();
}