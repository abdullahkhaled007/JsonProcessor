package com.cve.reader.jsondb;

import java.awt.Color;
import java.io.IOException;

import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cve.model.CveListObject;
import com.util.dataVisual.TimeSeriesChartGenerator;
import com.util.json.JSONFileTransformer;

@SpringBootApplication
public class CVEJsondbApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CVEJsondbApplication.class, args);
        System.setProperty("java.awt.headless", "false");
        SwingUtilities.invokeLater(() -> {
            CVEDatasetProcessor jsonProcessor;
            try {
                TimeSeriesChartGenerator chartGen = new TimeSeriesChartGenerator(
                        "Impact Occurrences",
                        "Date",
                        "Occurrences",
                        new Color(255, 228, 196),
                        640,
                        480);
                jsonProcessor = new CVEDatasetProcessor(
                        new CVEDatasetUtil(),
                        new JSONFileTransformer<>(CveListObject.class),
                        chartGen,
                        "src/main/resources/json/CVE.json");
                jsonProcessor.process();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
