package com.nile.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;


@Controller
public abstract class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    static {
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    }


    protected ResponseEntity<String> response(String key, Object resp) {
        Map<String, Object> respMap = new HashMap<String,Object>();
        respMap.put(key, resp);
        return response(respMap);
    }

    protected ResponseEntity<String> response(String key, Object resp, SerializeFilter filter) {
        Map<String, Object> respMap = new HashMap<>();
        respMap.put(key, resp);
        return response(respMap, filter);
    }

//    protected ResponseEntity<String> response(String key, Object resp, SerializerFeature... features) {
//        Map<String, Object> respMap = new HashMap<>();
//        respMap.put(key, resp);
//        return response(respMap, features);
//    }
//
//    protected ResponseEntity<String> response(Object resp, SerializerFeature... features) {
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.add("Content-Type", "application/json; charset=UTF-8");
//        features = ArrayUtils.add(features, SerializerFeature.DisableCircularReferenceDetect);
//        String json = JSON.toJSONStringWithDateFormat(resp, "yyyy-MM-dd HH:mm:ss", features);
//        return new ResponseEntity<>(json, headers, HttpStatus.OK);
//    }

    protected ResponseEntity<String> responseStr(String body) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }

    protected ResponseEntity<String> response(Object resp) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        String json = JSON.toJSONStringWithDateFormat(resp, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat);
        return new ResponseEntity<>(json, headers, HttpStatus.OK);
    }

    protected ResponseEntity<String> response(Object resp, SerializeFilter filter) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        String json = JSON.toJSONString(resp, filter, SerializerFeature.DisableCircularReferenceDetect);
        return new ResponseEntity<>(json, headers, HttpStatus.OK);
    }

    protected ResponseEntity<String> responseError() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        return new ResponseEntity<>("", headers, HttpStatus.BAD_REQUEST);
    }

}

