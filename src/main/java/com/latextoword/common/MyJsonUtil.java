package com.latextoword.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by maoyuwei on 2017/8/24.
 * JSON工具类
 */
public class MyJsonUtil {
    private static ObjectMapper mapper;

    /**
     * 初始化
     */
    private static void init(){
        if(mapper==null){
            mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
        }
    }

    /**
     * json转实体
     * @param jsonString json字符串
     * @param clazz 实体类
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        try {
            init();
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
        	e.printStackTrace();
            return null;
        }
    }

    /**
     * 实体转json
     * @param object 实体类
     * @return json字符串
     */
    public static String toJson(Object object) {
        try {
            init();
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    

    @SuppressWarnings({ "rawtypes", "deprecation" })
    public static List jsontoListClazz(String jsonString,Class<?> clazz){
        init();
        JavaType javaType=mapper.getTypeFactory().constructParametricType(List.class,clazz);
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
