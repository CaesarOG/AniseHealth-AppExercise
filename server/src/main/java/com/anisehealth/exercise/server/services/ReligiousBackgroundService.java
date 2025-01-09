package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.ReligiousBackground;
import com.anisehealth.exercise.server.repositories.ReligiousBackgroundRepository;

@Service
public class ReligiousBackgroundService {

    @Autowired
    private ReligiousBackgroundRepository religiousBackgroundRepository;

    public List<ReligiousBackground> findAll() {
        return religiousBackgroundRepository.findAll();
    }

    public List<ReligiousBackground> findByName(String name) {
        ReligiousBackground rel = new ReligiousBackground();
        rel.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return religiousBackgroundRepository.findAll(Example.of(rel, matcher));
    }
}