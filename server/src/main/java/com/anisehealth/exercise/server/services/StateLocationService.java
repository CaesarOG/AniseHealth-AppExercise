package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.StateLocation;
import com.anisehealth.exercise.server.repositories.StateLocationRepository;

@Service
public class StateLocationService {

    @Autowired
    private StateLocationRepository stateLocationRepository;

    public List<StateLocation> findAll() {
        return stateLocationRepository.findAll();
    }

    public List<StateLocation> findByName(String name) {
        StateLocation state = new StateLocation();
        state.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return stateLocationRepository.findAll(Example.of(state, matcher));
    }
}