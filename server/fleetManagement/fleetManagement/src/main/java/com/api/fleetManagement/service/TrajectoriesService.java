package com.api.fleetManagement.service;

import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;
import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TrajectoriesService {
    private final TrajectoriesRepository trajectoriesRepository;

    @Autowired
    public TrajectoriesService(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }

    public List<TaxiAllTrajectoriesDTO> getAllTrajectories(int id, Date date) {
        List<Trajectories> allTrajectories = trajectoriesRepository.findAll();
        List<TaxiAllTrajectoriesDTO> filterTrajectories = new ArrayList<>();

        for (Trajectories trajectory : allTrajectories) {
            TaxiAllTrajectoriesDTO dto = new TaxiAllTrajectoriesDTO(trajectory.getDate(), trajectory.getLatitude(),trajectory.getLongitude());
            filterTrajectories.add(dto);
        }
       return filterTrajectories;
    }

    public List<>
}
