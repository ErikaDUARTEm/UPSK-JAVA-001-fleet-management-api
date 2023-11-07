package com.api.fleetManagement.service;
import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.repository.TaxiRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaxiServiceTests {

    @Mock
    private TaxiRepository taxiRepository;

    private TaxiService taxiService;

    @BeforeEach
    void setUp() {
        openMocks(this);
        taxiService = new TaxiService(taxiRepository);
    }

    @Test
    @DisplayName("Acceder a lista de todos los taxis")
    public void testGetAllTaxis() {
        List<Taxi> taxis = new ArrayList<>();
        taxis.add(new Taxi(1, "Taxi1"));
        taxis.add(new Taxi(2, "Taxi2"));
        taxis.add(new Taxi(3, "Taxi3"));

        when(taxiRepository.findAll(Pageable.unpaged())).thenReturn(new PageImpl<>(taxis));

        Page<Taxi> result = taxiService.getAllTaxis(Pageable.unpaged());
        assertEquals(taxis, result.getContent());
    }
}
