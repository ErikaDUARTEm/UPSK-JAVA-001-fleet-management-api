package com.api.fleetManagement.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("api")
public class api {

//public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
   //     return String.format("Hello %s!", name);
   // }

        @Autowired
        private EntityManager entityManager;
        @GetMapping("testDatabaseConnection")
        @SuppressWarnings("unchecked")
        public List<String> testDatabaseConnection() {
            Query query = entityManager.createNativeQuery("SELECT 'Conexión exitosa' AS status");
            return query.getResultList();
        }



}
