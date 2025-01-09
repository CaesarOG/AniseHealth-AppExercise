package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.EmploymentStatus;
import com.anisehealth.exercise.server.repositories.EmploymentStatusRepository;

@Service
public class EmploymentStatusService {

    @Autowired
    private EmploymentStatusRepository employmentStatusRepository;

    public List<EmploymentStatus> findAll() {
        return employmentStatusRepository.findAll();
    }

    public List<EmploymentStatus> findByName(String name) {
        EmploymentStatus eStatus = new EmploymentStatus();
        eStatus.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return employmentStatusRepository.findAll(Example.of(eStatus, matcher));
    }
}
