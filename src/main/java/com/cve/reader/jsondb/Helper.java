package com.cve.reader.jsondb;

import com.cve.reader.jsondb.pojo.CveObject;
import com.cve.reader.jsondb.pojo.MonthYear;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Helper {

    public static final ObjectMapper OBJECT_MAPPER = getObjectMapper();

    private static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    void counter(List<CveObject> list, HashMap<MonthYear, Integer>[] maps) {

        for (CveObject current : list) {
            try {
                switch (current.getImpact().getBaseMetricV2().getSeverity()) {
                    case "LOW":
                        incrementOccurences(maps, current, 0);
                        break;
                    case "MEDIUM":
                        incrementOccurences(maps, current, 1);
                        break;
                    case "HIGH":
                        incrementOccurences(maps, current, 2);
                        break;
                    case "CRITICAL":
                        incrementOccurences(maps, current, 3);
                        break;
                }
            } catch (NullPointerException e) {
                System.out.println("Could not retrieve severity ");
            }
        }
    }

    private void incrementOccurences(HashMap<MonthYear, Integer>[] maps, CveObject current, int index) {
        MonthYear key = monthYearTransformer(current.getPublishedDate());
        if (maps[index].containsKey(key)) {
            maps[index].compute(key, (k, v) -> v + 1);
        } else {
            maps[index].put(monthYearTransformer(current.getPublishedDate()), 1);
        }
    }

    private MonthYear monthYearTransformer(LocalDateTime localDateTime) {
        return new MonthYear(
                localDateTime.getMonthValue(), localDateTime.getYear());
    }

    HashMap[] getHashMaps() {
        HashMap<MonthYear, Integer> low = new HashMap<>();
        HashMap<MonthYear, Integer> medium = new HashMap<>();
        HashMap<MonthYear, Integer> high = new HashMap<>();
        HashMap<MonthYear, Integer> critical = new HashMap<>();
        HashMap[] maps = new HashMap[]{low, medium, high, critical};
        return maps;
    }
}
