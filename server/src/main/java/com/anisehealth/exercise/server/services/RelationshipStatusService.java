package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.RelationshipStatus;
import com.anisehealth.exercise.server.repositories.RelationshipStatusRepository;

@Service
public class RelationshipStatusService {

    @Autowired
    private RelationshipStatusRepository relationshipStatusRepository;

    public List<RelationshipStatus> findAll() {
        return relationshipStatusRepository.findAll();
    }

    public List<RelationshipStatus> findByName(String name) {
        RelationshipStatus rel = new RelationshipStatus();
        rel.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return relationshipStatusRepository.findAll(Example.of(rel, matcher));
    }
}