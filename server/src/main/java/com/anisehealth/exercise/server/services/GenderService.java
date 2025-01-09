package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.Gender;
import com.anisehealth.exercise.server.repositories.GenderRepository;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    public List<Gender> findByName(String name) {
        Gender gdr = new Gender();
        gdr.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return genderRepository.findAll(Example.of(gdr, matcher));
    }
}
