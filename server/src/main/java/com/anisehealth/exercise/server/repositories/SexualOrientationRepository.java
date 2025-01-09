package com.anisehealth.exercise.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anisehealth.exercise.server.models.SexualOrientation;

@Repository
public interface SexualOrientationRepository extends JpaRepository<SexualOrientation, Long> { 
}