package com.devspods.repositories;

import com.devspods.domain.PostStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostStatusRepository extends CrudRepository<PostStatus, Long> {}
