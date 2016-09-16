package com.nile.controller;


import com.nile.entity.User;
import com.nile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserContoller extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> selectUserById(int id) {
        User user=userService.selectUserById(id);

        return response("user",user);
    }

}
