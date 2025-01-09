package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.TreatmentModality;
import com.anisehealth.exercise.server.repositories.TreatmentModalityRepository;

@Service
public class TreatmentModalityService {

    @Autowired
    private TreatmentModalityRepository treatmentModalityRepository;

    public List<TreatmentModality> findAll() {
        return treatmentModalityRepository.findAll();
    }

    public List<TreatmentModality> findByName(String name) {
        TreatmentModality mod = new TreatmentModality();
        mod.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return treatmentModalityRepository.findAll(Example.of(mod, matcher));
    }
}