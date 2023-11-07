package com.api.fleetManagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaxiControllerIntegrationTest {

    @LocalServerPort
    public int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllTaxis() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/taxiApi/all/taxis", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
