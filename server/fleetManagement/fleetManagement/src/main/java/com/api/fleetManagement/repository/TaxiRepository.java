package com.api.fleetManagement.repository;

import com.api.fleetManagement.model.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {

    @Query("SELECT t FROM Taxi t WHERE t.id = :id ORDER BY t.id ASC")
    Page<Taxi> findAll(@Param("id") int id, Pageable pageable);


}
