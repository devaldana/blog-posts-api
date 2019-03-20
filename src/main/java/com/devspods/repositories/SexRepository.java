package com.devspods.repositories;

import com.devspods.domain.Sex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepository extends CrudRepository<Sex, Long> {}
