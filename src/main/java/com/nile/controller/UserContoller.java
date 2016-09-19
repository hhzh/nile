package com.nile.controller;


import com.nile.entity.User;
import com.nile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserContoller extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> selectUserById() {
        User user=userService.selectUserById(1000);
        System.out.println(user.getName());
        //return new ResponseEntity<String>("abc", HttpStatus.OK);

        return response("user",user);
    }

}
