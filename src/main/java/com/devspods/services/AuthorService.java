package com.devspods.services;

import com.devspods.domain.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService extends CrudService<Author, Long> {
}
