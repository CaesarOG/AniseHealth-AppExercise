package com.anisehealth.exercise.server.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Ethnicity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ethnicities")
    @SuppressWarnings("unused")
    private Set<Provider> providers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy= "ethnicities")
    @SuppressWarnings("unused")
    private Set<Client> clients;

    public Ethnicity() {
        super();
    }

    public Ethnicity(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
