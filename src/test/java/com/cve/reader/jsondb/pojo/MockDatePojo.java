package com.cve.reader.jsondb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MockDatePojo {

    private String name;
    private LocalDateTime publishedDate;

    public LocalDateTime getDate() {
        return publishedDate;
    }

    public void setDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MockDatePojo(LocalDateTime publishedDate, String name) {
        this.publishedDate = publishedDate;
        this.name = name;
    }
}
