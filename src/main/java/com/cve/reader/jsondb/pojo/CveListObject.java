package com.cve.reader.jsondb.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class CveListObject {
    @JsonProperty
    private String CVE_data_type;
    @JsonProperty
    private String CVE_data_format;
    @JsonProperty
    private double CVE_data_version;
    @JsonProperty
    private int CVE_numberOfCVEs;
    @JsonProperty
    private Date CVE_time_stamp;
    @JsonProperty
    private List<CveObject> CVE_Items;

    public String getCVE_data_type() {
        return CVE_data_type;
    }

    public String getCVE_data_format() {
        return CVE_data_format;
    }

    public double getCVE_data_version() {
        return CVE_data_version;
    }

    public int getCVE_numberOfCVEs() {
        return CVE_numberOfCVEs;
    }

    public Date getCVE_time_stamp() {
        return CVE_time_stamp;
    }

    public List<CveObject> getCVE_Items() {
        return CVE_Items;
    }



}

