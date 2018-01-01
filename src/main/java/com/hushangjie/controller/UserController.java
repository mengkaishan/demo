package com.hushangjie.controller;


import com.hushangjie.dao.UserDao;
import com.hushangjie.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**

 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    UserDao userDAO;
@RequestMapping("/")
public String index(){
    return  "user";
}

    @RequestMapping(value = "/addUser" )
    @ResponseBody
    public String addUser(@Valid User user){

//        User user = new User();
//        user.setName(name);
//        user.setAddress(address);
//        user.setDate(date);
        userDAO.save(user);

        return "add user success !";
    }

    @RequestMapping(value = "/findById" )
    @ResponseBody
    public String findById(@RequestParam(value = "id") Long id){

        User user = userDAO.findById(id);

        if(user == null){
            return "error";
        }else{
            return "name:" + user.getName() + " , age:" + user.getAge();
        }
    }


    @RequestMapping(value = "/findAll" )
    @ResponseBody
    public List<User> findAll(HttpServletResponse resp){
        List<User> userList = (List<User>) userDAO.findAll();
        return userList;

    }

    @RequestMapping(value = "/deleteById" )
    @ResponseBody
    public String deleteById(@RequestParam(value = "id") Long id){
        userDAO.delete(id);
        return "delete success !";

    }
}

