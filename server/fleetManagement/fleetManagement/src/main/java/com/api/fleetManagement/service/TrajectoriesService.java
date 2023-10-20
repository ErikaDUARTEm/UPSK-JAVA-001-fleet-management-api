package com.api.fleetManagement.service;

import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrajectoriesService {
    private final TrajectoriesRepository trajectoriesRepository;

    @Autowired
    public TrajectoriesService(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }

    public Trajectories findLastLocationByTaxiId(int taxiId) {
        return trajectoriesRepository.findLastLocationByTaxiId(taxiId);
    }

}
