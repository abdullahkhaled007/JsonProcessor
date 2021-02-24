package com.cve.reader.jsondb.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseMetricV2 {

    @JsonProperty
    private String severity;
    @JsonProperty
    private double exploitabilityScore;
    @JsonProperty
    private double impactScore;
    @JsonProperty
    private boolean acInsufInfo;
    @JsonProperty
    private boolean obtainAllPrivilege;
    @JsonProperty
    private boolean obtainUserPrivilege;
    @JsonProperty
    private boolean obtainOtherPrivilege;
    @JsonProperty
    private boolean userInteractionRequired;

    public String getSeverity() {
        return severity;
    }

    public double getExploitabilityScore() {
        return exploitabilityScore;
    }

    public double getImpactScore() {
        return impactScore;
    }

    public boolean isAcInsufInfo() {
        return acInsufInfo;
    }

    public boolean isObtainAllPrivilege() {
        return obtainAllPrivilege;
    }

    public boolean isObtainUserPrivilege() {
        return obtainUserPrivilege;
    }

    public boolean isObtainOtherPrivilege() {
        return obtainOtherPrivilege;
    }

    public boolean isUserInteractionRequired() {
        return userInteractionRequired;
    }
}
