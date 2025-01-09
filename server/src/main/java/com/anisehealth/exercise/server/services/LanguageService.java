package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.Language;
import com.anisehealth.exercise.server.repositories.LanguageRepository;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    public List<Language> findByName(String name) {
        Language lan = new Language();
        lan.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        return languageRepository.findAll(Example.of(lan, matcher));
    }
}