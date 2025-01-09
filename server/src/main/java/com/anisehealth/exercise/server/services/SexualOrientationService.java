package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.SexualOrientation;
import com.anisehealth.exercise.server.repositories.SexualOrientationRepository;

@Service
public class SexualOrientationService {

    @Autowired
    private SexualOrientationRepository sexualOrientationRepository;

    public List<SexualOrientation> findAll() {
        return sexualOrientationRepository.findAll();
    }

    public List<SexualOrientation> findByName(String name) {
        SexualOrientation ort = new SexualOrientation();
        ort.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return sexualOrientationRepository.findAll(Example.of(ort, matcher));
    }
}
