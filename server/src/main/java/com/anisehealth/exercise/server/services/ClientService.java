package com.anisehealth.exercise.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.anisehealth.exercise.server.models.Client;
import com.anisehealth.exercise.server.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client login(String username) {
        Client client = new Client();
        client.setUsername(username);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("phone");
        System.out.println(clientRepository.findAll(Example.of(client, matcher)));
        return clientRepository.findOne(Example.of(client, matcher)).orElse(null);
    }

    public void save(Client client) throws org.springframework.dao.DataIntegrityViolationException {
        clientRepository.save(client);
    }
    
}
