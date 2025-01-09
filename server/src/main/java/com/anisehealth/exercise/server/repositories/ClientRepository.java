package com.anisehealth.exercise.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anisehealth.exercise.server.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // @Query("SELECT c FROM client c WHERE c.first_name LIKE %:name% OR c.last_name LIKE %:name%")
    // List<Client> findByName(@Param("name") String name);
}
