package com.nile.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserContoller{

//    @Autowired
//    private UserService userService;

    @RequestMapping(value = "/select")
    public String  selectUserById() {
//        User user=userService.selectUserById(1000);
//        System.out.println(user.getName());
        //return new ResponseEntity<String>("abc", HttpStatus.OK);

        System.out.println("Hello.");
//        return response("user",user);
        return "hello";
    }

}
