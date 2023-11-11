package com.api.fleetManagement.controllers;

import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TrajectoriesRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/excelExport")
public class ExcelExportController {

    private final TrajectoriesRepository trajectoriesRepository;

    @Autowired
    public ExcelExportController(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportToExcel(
            @RequestParam("id") int id,
            @RequestParam("date") String dateStr
    ) {
        try {
            List<Trajectories> allTrajectories = trajectoriesRepository.findTrajectoriesByTaxiIdAndDate(id, dateStr);

            if (allTrajectories.isEmpty()) {
                return ResponseEntity.noContent().build(); // No data to export
            }

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Trajectories");

            // Crear las cabeceras
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("License");
            headerRow.createCell(2).setCellValue("Date");
            headerRow.createCell(3).setCellValue("Latitude");
            headerRow.createCell(4).setCellValue("Longitude");

            int rowNum = 1;
            for (Trajectories trajectory : allTrajectories) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(trajectory.getTaxi().getId());
                row.createCell(1).setCellValue(trajectory.getTaxi().getLicense());
                row.createCell(2).setCellValue(trajectory.getDate().toString());
                row.createCell(3).setCellValue(trajectory.getLatitude());
                row.createCell(4).setCellValue(trajectory.getLongitude());
            }

            // Preparar la respuesta para el cliente
            byte[] excelContent;
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                workbook.write(baos);
                excelContent = baos.toByteArray();
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=trajectories_" + id + "_" + dateStr + ".xlsx");

            return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")).body(excelContent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
