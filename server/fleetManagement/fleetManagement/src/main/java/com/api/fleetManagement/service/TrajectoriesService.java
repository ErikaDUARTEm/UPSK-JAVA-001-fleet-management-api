package com.api.fleetManagement.service;

import com.api.fleetManagement.Dto.LastTrajectoryDTO;
import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TrajectoriesService {
    private final TrajectoriesRepository trajectoriesRepository;

    @Autowired
    public TrajectoriesService(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }



    public Page<TaxiAllTrajectoriesDTO> getAllTrajectories(int id, String dateStr, Pageable pageable) throws ParseException {
        List<Trajectories> allTrajectories = trajectoriesRepository.findTrajectoriesByTaxiIdAndDate(id, dateStr);

        List<TaxiAllTrajectoriesDTO> filterTrajectories = new ArrayList<>();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), allTrajectories.size());

        if (!allTrajectories.isEmpty() && start <= end) {
            for (int i = start; i < end; i++) {
                Trajectories trajectory = allTrajectories.get(i);
                TaxiAllTrajectoriesDTO dto = new TaxiAllTrajectoriesDTO(trajectory.getDate(), trajectory.getLatitude(), trajectory.getLongitude());
                filterTrajectories.add(dto);
            }
        } else {
            System.out.println("No existen trayectorias para este taxi en esta fecha.");
        }

        return new PageImpl<>(filterTrajectories, pageable, allTrajectories.size());
    }


    public Page<LastTrajectoryDTO> getLastTrajectory(Pageable pageable) {
        List<Trajectories> allTrajectories = trajectoriesRepository.findAll();

        if (allTrajectories.isEmpty()) {
            return Page.empty();
        }

        Map<Integer, Trajectories> lastTrajectoriesMap = allTrajectories.stream()
                .collect(Collectors.toMap(
                        trajectory -> trajectory.getTaxi().getId(),
                        Function.identity(),
                        (existing, replacement) -> existing.getDate().after(replacement.getDate()) ? existing : replacement
                ));

        List<LastTrajectoryDTO> lastTrajectories = lastTrajectoriesMap.values().stream()
                .map(trajectory -> {
                    int trajectoryId = trajectory.getTaxi().getId();
                    String trajectoryLicense = trajectory.getTaxi().getLicense();
                    double trajectoryLatitude = trajectory.getLatitude();
                    double trajectoryLongitude = trajectory.getLongitude();
                    Date trajectoryDate = trajectory.getDate();
                    return new LastTrajectoryDTO(trajectoryId, trajectoryLicense, trajectoryLatitude, trajectoryLongitude, trajectoryDate);
                })
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), lastTrajectories.size());

        if (start < end) {
            return new PageImpl<>(lastTrajectories.subList(start, end), pageable, lastTrajectories.size());
        } else {
            return Page.empty();
        }
    }
}
