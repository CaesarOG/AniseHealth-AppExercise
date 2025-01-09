package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.Ethnicity;
import com.anisehealth.exercise.server.repositories.EthnicityRepository;

@Service
public class EthnicityService {

    @Autowired
    private EthnicityRepository ethnicityRepository;

    public List<Ethnicity> findAll() {
        return ethnicityRepository.findAll();
    }

    public List<Ethnicity> findByName(String name) {
        Ethnicity eth = new Ethnicity();
        eth.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return ethnicityRepository.findAll(Example.of(eth, matcher));
    }
}
