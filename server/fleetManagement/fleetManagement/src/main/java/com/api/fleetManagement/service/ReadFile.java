package com.api.fleetManagement.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
@Service
public class ReadFile{

        public static String readFile(String path ) {
            StringBuilder content = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
            } catch (IOException ignored) {

            }
            return content.toString();
        }


}
