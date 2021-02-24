package com.cve.reader.jsondb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;


public class CveObject {

    @JsonProperty
    private Impact impact;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmz")
    private LocalDateTime publishedDate;

    public CveObject() {
        super();
    }

    public Impact getImpact() {
        return impact;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    @Override
    public String toString() {
        return "CveObject{" +
                "publishedDate='" + publishedDate + '\'' +
                '}';
    }
}
