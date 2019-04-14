package com.devspods.services.impl;

import com.devspods.domain.Gender;
import com.devspods.repositories.GenderRepository;
import com.devspods.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    private GenderRepository genderRepository;

    @Autowired
    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public Gender save(Gender gender) {
        return this.genderRepository.save(gender);
    }

    @Override
    public Gender findById(Long id) {
        return this.genderRepository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Gender not found with the given ID"));
    }

    @Override
    public void deleteById(Long id) {
        this.genderRepository.deleteById(id);
    }

    @Override
    public List<Gender> findAll() {
        return this.genderRepository.findAll();
    }
}
