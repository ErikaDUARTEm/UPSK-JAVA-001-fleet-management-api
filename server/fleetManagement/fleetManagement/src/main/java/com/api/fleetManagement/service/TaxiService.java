package com.api.fleetManagement.service;

import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class TaxiService {
    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxiService(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }


    public Taxi getTaxiById(int id) {

        return taxiRepository.findById(id);
    }


    public List<Taxi> getAll() {
        return taxiRepository.findAll();
    }

   
        public List<Trajectories> getTraject(int id) {
            Taxi taxi = taxiRepository.findById(id);
            if (taxi != null) {
                return taxi.getTrajectories();
            } else {
                return Collections.emptyList();
            }

        }
    }
