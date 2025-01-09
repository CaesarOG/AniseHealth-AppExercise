package com.anisehealth.exercise.server.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Provider extends User {

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
        name = "provider_ethnicity", 
        joinColumns = @JoinColumn(name = "provider_id"), 
        inverseJoinColumns = @JoinColumn(name = "ethnicity_id"))
    private Set<Ethnicity> ethnicities;

    @ManyToMany
    @JoinTable(
        name = "provider_language", 
        joinColumns = @JoinColumn(name = "provider_id"), 
        inverseJoinColumns = @JoinColumn(name = "language_id"))
    private Set<Language> languages;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    private int clientCapacity;

    @ManyToMany
    @JoinTable(
        name = "provider_state", 
        joinColumns = @JoinColumn(name = "provider_id"), 
        inverseJoinColumns = @JoinColumn(name = "state_location_id"))
    private Set<StateLocation> states;

    // @jakarta.persistence.Lob
    @jakarta.persistence.Column(columnDefinition = "TEXT")
    private String bio;

    @ManyToOne
    @JoinColumn(name = "sexual_orientation_id")
    private SexualOrientation sexualOrientation;

    @ManyToOne
    @JoinColumn(name = "religious_background_id")
    private ReligiousBackground religiousBackground;

    @ManyToMany
    @JoinTable(
        name = "provider_modality", 
        joinColumns = @JoinColumn(name = "provider_id"), 
        inverseJoinColumns = @JoinColumn(name = "treatment_modality_id"))
    private Set<TreatmentModality> treatmentModalities;

    @ManyToMany
    @JoinTable(
        name = "provider_specialization", 
        joinColumns = @JoinColumn(name = "provider_id"), 
        inverseJoinColumns = @JoinColumn(name = "specialization_id"))
    private Set<Specialization> specializations;

    public Provider() {
        super();
    }

    public Provider(Long id, String username, String firstName, String lastName, Set<Ethnicity> ethnicities, Gender gender, 
        int clientCapacity, Set<Language> languages, Set<StateLocation> states, String bio, SexualOrientation sexualOrientation, 
        ReligiousBackground religiousBackground, Set<TreatmentModality> treatmentModalities, Set<Specialization> specializations) {
        super(id, username);

        this.firstName = firstName;
        this.lastName = lastName;

        this.ethnicities = ethnicities;
        this.gender = gender;
        this.clientCapacity = clientCapacity;
        this.languages = languages;
        this.states = states;
        this.bio = bio;
        this.sexualOrientation = sexualOrientation;
        this.religiousBackground = religiousBackground;
        this.treatmentModalities = treatmentModalities;
        this.specializations = specializations;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullString () {
        return this.firstName + " " + this.lastName;
    }

    public Set<Ethnicity> getEthnicities() {
        return ethnicities;
    }

    public void setEthnicities(Set<Ethnicity> ethnicities) {
        this.ethnicities = ethnicities;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getClientCapacity() {
        return clientCapacity;
    }

    public void setClientCapacity(int clientCapacity) {
        this.clientCapacity = clientCapacity;
    }

    public Set<StateLocation> getStates() {
        return states;
    }

    public void setStates(Set<StateLocation> states) {
        this.states = states;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public SexualOrientation getSexualOrientations() {
        return sexualOrientation;
    }

    public void setSexualOrientations(SexualOrientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public ReligiousBackground getReligiousBackground() {
        return religiousBackground;
    }

    public void setReligiousBackground(ReligiousBackground religiousBackground) {
        this.religiousBackground = religiousBackground;
    }

    public Set<TreatmentModality> getTreatmentModalities() {
        return treatmentModalities;
    }

    public void setTreatmentModalities(Set<TreatmentModality> treatmentModalities) {
        this.treatmentModalities = treatmentModalities;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    @Override
    public String toString() {
        return "Provider [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", clientCap="+ clientCapacity+
        ", ethnicities=" + ethnicities.toString() + ", languages=" + languages.toString() + ", states=" + states.toString()
        + ", specializations" + specializations.toString() +"]";

    // ", \ngender="+ gender.toString() + ", religiousBackground=" + religiousBackground.toString()
    }
    
}
