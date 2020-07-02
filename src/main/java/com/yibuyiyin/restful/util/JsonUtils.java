package com.yibuyiyin.restful.util;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Map;

/**
 * JSON工具类
 */
public class JsonUtils {
    private static final ObjectMapper mapper;
    static {
        (mapper = new ObjectMapper()).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JsonUtils.mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
    public static String obj2json(final Object obj) throws JsonProcessingException {
        return JsonUtils.mapper.writeValueAsString(obj);
    }
    
    public static <T> T json2obj(final String json, final Class<T> valueType) throws JsonParseException, JsonMappingException, IOException {
        return (T)JsonUtils.mapper.readValue(json, valueType);
    }
    
    @SuppressWarnings("unchecked")
	public static Map<String, Object> obj2map(final Object obj) {
        return (Map<String, Object>)JsonUtils.mapper.convertValue(obj, Map.class);
    }
    
    public static <T> T map2obj(final Map<String, Object> propertyMap, final Class<T> valueType) {
        return JsonUtils.mapper.convertValue(propertyMap, valueType);
    }
    
}

