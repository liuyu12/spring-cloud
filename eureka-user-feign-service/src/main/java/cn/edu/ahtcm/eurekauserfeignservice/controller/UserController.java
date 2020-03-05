package cn.edu.ahtcm.eurekauserfeignservice.controller;

import cn.edu.ahtcm.common.entity.User;
import cn.edu.ahtcm.eurekauserfeignservice.service.UserService;
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
    public Object detail(int id){
        return userService.findById(id);
    }

}
