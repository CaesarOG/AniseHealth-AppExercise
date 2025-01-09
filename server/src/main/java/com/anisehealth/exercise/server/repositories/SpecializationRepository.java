package com.anisehealth.exercise.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anisehealth.exercise.server.models.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}