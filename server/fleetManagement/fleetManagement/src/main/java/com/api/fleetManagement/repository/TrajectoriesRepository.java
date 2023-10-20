package com.api.fleetManagement.repository;


import com.api.fleetManagement.model.Trajectories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectories, Integer> {
    @Query("SELECT t FROM Trajectories t WHERE t.taxi.id = :taxiId  ORDER BY t.fecha DESC, t.hora DESC")
    Trajectories findLastLocationByTaxiId(@Param("taxiId") int taxiId);

}
