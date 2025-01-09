package com.anisehealth.exercise.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anisehealth.exercise.server.models.TreatmentModality;

@Repository
public interface TreatmentModalityRepository extends JpaRepository<TreatmentModality, Long> {
}