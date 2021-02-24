package com.cve.reader.jsondb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.io.IOException;

@SpringBootApplication
public class JsondbApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(JsondbApplication.class, args);
        SwingUtilities.invokeLater(() -> {
            JsonProcessor jsonProcessor = null;
            try {
                jsonProcessor = new JsonProcessor("src/main/resources/json/CVE.json");
                jsonProcessor.setSize(800, 400);
                jsonProcessor.setLocationRelativeTo(null);
                jsonProcessor.setVisible(true);
                jsonProcessor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
