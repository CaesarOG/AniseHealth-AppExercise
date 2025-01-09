package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.Generation;
import com.anisehealth.exercise.server.repositories.GenerationRepository;

@Service
public class GenerationService {

    @Autowired
    private GenerationRepository generationRepository;

    public List<Generation> findAll() {
        return generationRepository.findAll();
    }

    public List<Generation> findByName(String name) {
        Generation gen = new Generation();
        gen.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return generationRepository.findAll(Example.of(gen, matcher));
    }
}