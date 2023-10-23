package com.api.fleetManagement.service;

import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
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


    //método que devuelve todas las trayectorias de un taxi por fecha.
    public List<Trajectories> getAllTrajectories(int id, Date fecha) {
            Taxi taxi = taxiRepository.findById(id);

            if (taxi != null) {
                List<Trajectories> allTrajectories = taxi.getTrajectories();
                List<Trajectories> filteredTrajectories = new ArrayList<>();

                for (Trajectories trajectory : allTrajectories) {
                    if (trajectory.getFecha().equals(fecha)) {
                        filteredTrajectories.add(trajectory);
                    }
                }

                return filteredTrajectories;
            }else {
                return Collections.emptyList();
        }
    }
}
