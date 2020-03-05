package cn.edu.ahtcm.userservice.service.impl;

import cn.edu.ahtcm.userservice.dao.UserMapper;
import cn.edu.ahtcm.userservice.entity.Role;
import cn.edu.ahtcm.userservice.entity.User;
import cn.edu.ahtcm.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        User user = userMapper.findById(id).get();
        // 通过服务查询用户角色信息
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8081/role-service/listRoles?id="+id, List.class);
        List<Role> roles = (List<Role>)responseEntity.getBody();
        user.setRoles(roles);
        return user;
    }
}
