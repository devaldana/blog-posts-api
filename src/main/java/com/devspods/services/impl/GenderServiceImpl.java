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
        return genderRepository.save(gender);
    }

    @Override
    public Gender findById(Long id) {
        return genderRepository.findById(id)
                               .orElseThrow(() -> new EntityNotFoundException("Gender not found with the given ID"));
    }

    @Override
    public void deleteById(Long id) {
        genderRepository.deleteById(id);
    }

    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }
}
