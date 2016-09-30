package com.nile.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nile.entity.User;
import com.nile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public ResponseEntity<String> selectAll() {
        List<User> users=userService.selectAll();
        return response(users);
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public String query(@RequestBody User user) {
        return user.toString();
    }

    @RequestMapping("/re")
    @ResponseBody
    public ResponseEntity<String> re(@RequestBody User user) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("user", user);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        String json = JSON.toJSONStringWithDateFormat(resMap, "yyyy-MM-dd HH:mm:ss", SerializerFeature.DisableCircularReferenceDetect);
        return new ResponseEntity<String>(json, headers, HttpStatus.OK);
    }
}
