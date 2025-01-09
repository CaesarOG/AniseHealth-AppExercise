package com.anisehealth.exercise.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anisehealth.exercise.server.models.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    // @Query("SELECT p FROM provider p WHERE p.first_name LIKE %:name% OR p.last_name LIKE %:name%")
    // List<Provider> findByName(@Param("name") String name);
}