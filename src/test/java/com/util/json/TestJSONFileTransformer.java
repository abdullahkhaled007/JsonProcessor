package com.util.json;

import com.cve.model.CveListObject;
import com.cve.model.CveObject;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestJSONFileTransformer {
    //test that expected object is created when mock json is passed in
    JSONFileTransformer mockTransformer = new JSONFileTransformer(CveListObject.class);
    CveListObject mockCveListObject = new CveListObject();
    List<CveObject> cveListObjectList = new ArrayList<>();

    @Test
    void returnExpectedObjectedWhenJsonParsed() throws IOException {
        mockCveListObject.setCVE_data_type("CVE");
        mockCveListObject.setCVE_data_format("MITRE");
        mockCveListObject.setCVE_data_version(4.0);
        mockCveListObject.setCVE_numberOfCVEs(1173);
        mockCveListObject.setCVE_Items(cveListObjectList);
        Object output = mockTransformer.transformJson("src/test/resources/mockjson.json");
        Assertions.assertEquals(mockCveListObject.toString(), output.toString());
    }
}
