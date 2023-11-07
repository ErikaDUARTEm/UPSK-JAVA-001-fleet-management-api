package com.api.fleetManagement.service;

import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TrajectoriesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;


public class TrajectoriesServiceTests {
    @Mock
    private TrajectoriesRepository trajectoriesRepository;

    private TrajectoriesService trajectoriesService;

    @BeforeEach
    void setUp() {
        openMocks(this);
        trajectoriesService = new TrajectoriesService(trajectoriesRepository);
    }

    @Test
    void getAllTrajectoriesTest() throws ParseException {

            // Datos de prueba
            int taxiId = 1;
            String dateStr = "2023-11-04";
            List<Trajectories> mockTrajectories = new ArrayList<>();
            mockTrajectories.add(new Trajectories(1, taxiId, dateStr, 116.41155, 39.91265));
            mockTrajectories.add(new Trajectories(2, taxiId, dateStr, 116.41167, 39.90951));


            when(trajectoriesRepository.findTrajectoriesByTaxiIdAndDate(taxiId, dateStr)).thenReturn(mockTrajectories);

            PageRequest pageRequest = PageRequest.of(0, 50);

            Page<TaxiAllTrajectoriesDTO> result = trajectoriesService.getAllTrajectories(taxiId, dateStr, pageRequest);

            assertFalse(result.isEmpty());

            assertEquals(2, result.getContent().size());

            assertEquals(116.41155, result.getContent().get(0).getLatitude());
            assertEquals(39.91265, result.getContent().get(0).getLongitude());
            assertEquals(116.41167, result.getContent().get(1).getLatitude());
            assertEquals(39.90951, result.getContent().get(1).getLongitude());
        }

    }
