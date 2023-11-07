package com.api.fleetManagement.repository;

import com.api.fleetManagement.model.Trajectories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectories, Integer> {

    @Query(value = "SELECT * FROM trajectories t WHERE t.taxi_id = :id AND to_char(t.date, 'YYYY-MM-DD') = :date", nativeQuery = true)
    List<Trajectories> findTrajectoriesByTaxiIdAndDate(
            @Param("id") int id,
            @Param("date") String date);


}
