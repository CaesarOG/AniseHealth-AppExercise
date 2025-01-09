package com.anisehealth.exercise.server.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class StateLocation {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String abbreviation;

    @ManyToMany(mappedBy = "states", fetch = FetchType.LAZY)
    @SuppressWarnings("unused")
    private Set<Provider> providers;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @SuppressWarnings("unused")
    private final List<Client> clients = new ArrayList<>();

    public StateLocation() {
        super();
    }

    public StateLocation(Long id, String name, String abbreviation) {
        super();
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
