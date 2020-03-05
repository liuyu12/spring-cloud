package cn.edu.ahtcm.eurekauserservice.controller;

import cn.edu.ahtcm.common.entity.User;
import cn.edu.ahtcm.eurekauserservice.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "detailFB",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    @GetMapping("detail")
    public Object detail(int id){
        return userService.findById(id);
    }

    /**
     * 降级方法
     * @return
     */
    public Object detailFB(int id){
        return "用户inxi获取失败";
    }
}
