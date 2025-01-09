package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.Provider;
import com.anisehealth.exercise.server.repositories.ProviderRepository;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    public Provider login(String username) {
        Provider provider = new Provider();
        provider.setUsername(username);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("clientCapacity");

        return providerRepository.findOne(Example.of(provider, matcher)).orElse(null);
    }

    public List<Provider> findByFields(Provider provider) {
        ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnorePaths("clientCapacity", "username", "passwordHash", "salt").withStringMatcher(StringMatcher.CONTAINING).withIgnoreCase();
        System.out.println("ProviderService.findByFields");
        System.out.println(provider);
        List<Provider> providers = providerRepository.findAll(Example.of(provider, matcher));

        if (providers.size() > 3) {
            return providers.subList(0, 3);
        } else {
            return providers;
        }
    }

    public List<Provider> filterByFields(Provider provider) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("clientCapacity", "username", "passwordHash", "salt", "bio", "treatmentModalities").withStringMatcher(StringMatcher.CONTAINING).withIgnoreCase();
        System.out.println("ProviderService.filterByFields");
        System.out.println(provider);
        List<Provider> providers = providerRepository.findAll(Example.of(provider, matcher));

        if (providers.size() > 3) {
            return providers.subList(0, 3);
        } else {
            return providers;
        }
    }

    public void save(Provider provider) {
        providerRepository.save(provider);
    }

    // public List<Provider> findByName(String name) {
    //     return providerRepository.findByName(name);
    // }
}

