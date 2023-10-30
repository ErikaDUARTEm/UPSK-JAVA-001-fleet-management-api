package com.api.fleetManagement.repository;


import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;
import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.model.Trajectories;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectories, Integer> {

    @Query(value = "SELECT * " +
            "FROM public.trajectories " +
            "WHERE taxi_id = :id " +
            "AND DATE(date) = :date", nativeQuery = true)
    List<Trajectories> findTrajectoriesByTaxi_idAndDate(
            @Param("id") int id,
            @Param("date") Date date
    );


}
