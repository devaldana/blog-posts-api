package com.devspods.services.impl;

import com.devspods.domain.PostStatus;
import com.devspods.repositories.PostStatusRepository;
import com.devspods.services.PostStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PostStatusServiceImpl implements PostStatusService {

    private PostStatusRepository postStatusRepository;

    @Autowired
    public PostStatusServiceImpl(PostStatusRepository postStatusRepository) {
        this.postStatusRepository = postStatusRepository;
    }

    @Override
    public PostStatus save(PostStatus status) {
        return this.postStatusRepository.save(status);
    }

    @Override
    public PostStatus findById(Long id) {
        return this.postStatusRepository.findById(id)
                                        .orElseThrow(() -> new EntityNotFoundException("PostStatus not found with the given ID"));
    }

    @Override
    public void deleteById(Long id) {
        this.postStatusRepository.deleteById(id);
    }

    @Override
    public List<PostStatus> findAll() {
        return this.postStatusRepository.findAll();
    }
}
