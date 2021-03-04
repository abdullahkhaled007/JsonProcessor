package com.cve.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Impact {

    @JsonProperty
    private BaseMetricV2 baseMetricV2;

    public BaseMetricV2 getBaseMetricV2() {
        return baseMetricV2;
    }
}
