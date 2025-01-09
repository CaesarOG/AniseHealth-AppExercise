package com.anisehealth.exercise.server.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Client extends User {

    private String firstName;
    private String lastName;
    private String email;
    private long phone;

    public Client() {
        super();
    }

    public Client(Long id, String username, String firstName, String lastName, String email, long phone,
        Date dob, StateLocation state, Gender gender, SexualOrientation sexualOrientation, Set<Ethnicity> ethnicities, Generation generation,
        RelationshipStatus relationshipStatus, EmploymentStatus employmentStatus, ReligiousBackground religiousBackground) {
        super(id, username);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;

        this.state = state;
        this.gender = gender;
        this.sexualOrientation = sexualOrientation;
        this.ethnicities = ethnicities;
        this.generation = generation;
        this.relationshipStatus = relationshipStatus;
        this.employmentStatus = employmentStatus;
        this.religiousBackground = religiousBackground;
    }

    @ManyToOne
    @JoinColumn(name = "state_location_id")
    private StateLocation state;

    private Date dob;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "sexual_orientation_id")
    private SexualOrientation sexualOrientation;

    @ManyToMany
    @JoinTable(
        name = "client_ethnicity", 
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "ethnicity_id"))
    private Set<Ethnicity> ethnicities;

    @ManyToOne
    @JoinColumn(name = "generation_id")
    private Generation generation;

    @ManyToOne
    @JoinColumn(name = "relationship_status_id")
    private RelationshipStatus relationshipStatus;

    @ManyToOne
    @JoinColumn(name = "employment_status_id")
    private EmploymentStatus employmentStatus;

    @ManyToOne
    @JoinColumn(name = "religious_background_id")
    private ReligiousBackground religiousBackground;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public StateLocation getState() {
        return state;
    }

    public void setState(StateLocation state) {
        this.state = state;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public SexualOrientation getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(SexualOrientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public Set<Ethnicity> getEthnicities() {
        return ethnicities;
    }

    public void setEthnicities(Set<Ethnicity> ethnicities) {
        this.ethnicities = ethnicities;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public RelationshipStatus getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(RelationshipStatus relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public ReligiousBackground getReligiousBackground() {
        return religiousBackground;
    }

    public void setReligiousBackground(ReligiousBackground religiousBackground) {
        this.religiousBackground = religiousBackground;
    }
}
