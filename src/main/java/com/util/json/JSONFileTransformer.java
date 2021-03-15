package com.util.json;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONFileTransformer<T> {
    private final Class<T> clazz;

    public JSONFileTransformer(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T transformJson(String filePath) throws IOException {
        ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapper();
        T obj = objectMapper.readValue(new File(filePath), clazz);
        return obj;
    }
}
