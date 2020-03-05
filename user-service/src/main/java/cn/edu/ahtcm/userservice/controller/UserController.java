package cn.edu.ahtcm.userservice.controller;

import cn.edu.ahtcm.userservice.entity.User;
import cn.edu.ahtcm.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("listAll")
    public List<User> listAll(){
        return userService.findAll();
    }

    @GetMapping("detail")
    public User detail(int id){
        return userService.findById(id);
    }
}
