package com.cve.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public void setCVE_data_type(String CVE_data_type) {
        this.CVE_data_type = CVE_data_type;
    }

    public void setCVE_data_format(String CVE_data_format) {
        this.CVE_data_format = CVE_data_format;
    }

    public void setCVE_data_version(double CVE_data_version) {
        this.CVE_data_version = CVE_data_version;
    }

    public void setCVE_numberOfCVEs(int CVE_numberOfCVEs) {
        this.CVE_numberOfCVEs = CVE_numberOfCVEs;
    }

    public void setCVE_time_stamp(Date CVE_time_stamp) {
        this.CVE_time_stamp = CVE_time_stamp;
    }

    public void setCVE_Items(List<CveObject> CVE_Items) {
        this.CVE_Items = CVE_Items;
    }

    @Override
    public String toString() {
        return "CveListObject{" +
                "CVE_data_type='" + CVE_data_type + '\'' +
                ", CVE_data_format='" + CVE_data_format + '\'' +
                ", CVE_data_version=" + CVE_data_version +
                ", CVE_numberOfCVEs=" + CVE_numberOfCVEs +
                ", CVE_time_stamp=" + CVE_time_stamp +
                ", CVE_Items=" + CVE_Items +
                '}';
    }
}

