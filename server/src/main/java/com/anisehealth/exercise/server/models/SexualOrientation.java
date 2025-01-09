package com.anisehealth.exercise.server.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SexualOrientation {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "sexualOrientation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @SuppressWarnings("unused")
    private final List<Client> clients = new ArrayList<>();

    @OneToMany(mappedBy = "sexualOrientation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @SuppressWarnings("unused")
    private final List<Provider> providers = new ArrayList<>();

    public SexualOrientation() {
        super();
    }

    public SexualOrientation(Long id, String name) {
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
