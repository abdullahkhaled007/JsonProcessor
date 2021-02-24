package com.cve.reader.jsondb;

import com.cve.reader.jsondb.dataVisual.ChartGenerator;
import com.cve.reader.jsondb.pojo.CveListObject;
import com.cve.reader.jsondb.pojo.CveObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JsonProcessor extends JFrame {

    public JsonProcessor(String file) throws IOException {
        super(file);
        this.jsonExtractor(file);
    }

    ChartGenerator chartGenerator = new ChartGenerator();
    Helper helper = new Helper();

    public void jsonExtractor(String file) throws IOException {
        List<CveObject> currentList = getCveObjects(file);

        HashMap[] maps = helper.getHashMaps();

        helper.counter(currentList, maps);
        chartGenerator.extracted(maps);
        chartGenerator.chartBuilder();
    }

    protected List<CveObject> getCveObjects(String file) throws IOException {
        ObjectMapper objectMapper = helper.OBJECT_MAPPER;
        CveListObject obj = objectMapper.readValue(new File(file), CveListObject.class);
        return obj.getCVE_Items();
    }
}

