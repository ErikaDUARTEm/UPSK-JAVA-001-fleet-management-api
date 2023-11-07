package com.api.fleetManagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AllRoutesByTaxiAndDateControllerIntegrationTest {

    @LocalServerPort
    public int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllTrajectories() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        int taxiId = 6000;
        String dateStr = "2008-02-02";
        int page = 0;
        int size = 50;


        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:" + port + "/allTrajectoriesByDate/all?id=" + taxiId +
                        "&date=" + dateStr + "&page=" + page + "&size=" + size,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class
        );

        // Verificar que la respuesta es OK (código 200)
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
