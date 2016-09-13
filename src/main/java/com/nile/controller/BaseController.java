package com.nile.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Strings;
import com.silinkeji.chime.vo.BaseResponseVo;
import com.silinkeji.dto.sso.UserDto;
import com.silinkeji.enums.chime.TaskSource;
import com.silinkeji.exception.BaseException;
import com.silinkeji.exception.InvalidTokenException;
import com.silinkeji.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Controller
public abstract class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public static String HEADER_APPID     = "X-App-Id";
    public static String HEADER_TOKEN     = "X-Token";
    public static String HEADER_CLIENT_ID = "X-Client-Id";

    static {
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    }

    public String getToken(HttpServletRequest request) {
        String token = (String) request.getSession().getAttribute("token");
        if (Strings.isNullOrEmpty(token)) {
            throw new InvalidTokenException();
        }
        return token;
    }

    public UserDto getUser(HttpServletRequest request) {
        UserDto user = (UserDto) request.getSession().getAttribute("user");
        if (user == null) {
            throw new InvalidTokenException();
        }
        return user;
    }

    public String getClientId(HttpServletRequest request) {
        String clientId = (String) request.getSession().getAttribute("clientId");
        return Strings.isNullOrEmpty(clientId) ? "" : clientId;
    }

//    protected ResponseEntity<String> response(Map<String, Object> resp) {
//        String json = JSON.toJSONStringWithDateFormat(resp, "yyyy-MM-dd HH:mm:ss", SerializerFeature.DisableCircularReferenceDetect);
//        return new ResponseEntity<>(json, HttpStatus.OK);
//    }

    protected ResponseEntity<String> response(String key, Object resp) {
        Map<String, Object> respMap = new HashMap<>();
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
        String json = JSON.toJSONStringWithDateFormat(resp, "yyyy-MM-dd HH:mm:ss", SerializerFeature.DisableCircularReferenceDetect);
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

    protected TaskSource getSource(HttpServletRequest request) {
        String source = request.getHeader(HEADER_CLIENT_ID).split("\\.")[0];
        if ("ios".equalsIgnoreCase(source) || "android".equalsIgnoreCase(source)) {
            return TaskSource.APP;
        } else if ("callcenter".equalsIgnoreCase(source)) {
            return TaskSource.CALLCENTER;
        } else if ("web".equalsIgnoreCase(source)) {
            return TaskSource.WEB;
        } else {
            return TaskSource.CALLCENTER;
        }
    }
}

