package com.nile.controller;


import com.nile.entity.Admin;
import com.nile.entity.Book;
import com.nile.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserContoller {

//    @Autowired
//    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/select")
    public String selectUserById(@RequestParam("xage") int age) {
//        User user=userService.selectUserById(1000);
//        System.out.println(user.getName());
        //return new ResponseEntity<String>("abc", HttpStatus.OK);

//        System.out.println("Hello. ");
//        return response("user",user);
        return "age:" + age;
    }

    @RequestMapping("/query")
    @ResponseBody
    public String query(Integer age) {
        return "age:"+age;
    }

    @RequestMapping("/array")
    @ResponseBody
    public String array(String[] age) { // /array?age=Tom&age=Lucy
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : age) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    @RequestMapping("/object")
    @ResponseBody
    public String object(User user) { // /object?id=10&name=Jam
        return user.toString();
    }

    @RequestMapping("/object1")
    @ResponseBody
    public String object1(User user) { // /object?id=10&name=Jam&book.id=10 多层级对象属性
        return user.toString();
    }

    @RequestMapping("/object2")
    @ResponseBody
    public String object2(Admin admin,Book book) { // /object?admin.id=10&name=Jam&book.id=10 同级属性
        return admin.toString()+":"+book.toString();
    }

//    @InitBinder("admin")
//    public void initAdmin(WebDataBinder binder) {
//        binder.setFieldDefaultPrefix("admin.");
//    }
//
//    @InitBinder("book")
//    public void initBook(WebDataBinder binder) {
//        binder.setFieldDefaultPrefix("book.");
//    }

    @RequestMapping("/json")
    @ResponseBody
    public String json(@RequestBody Book book) {
        return book.toString();
    }




}