package cn.edu.ahtcm.eurekauserservice.service.impl;

import cn.edu.ahtcm.common.dao.UserMapper;
import cn.edu.ahtcm.common.entity.Role;
import cn.edu.ahtcm.common.entity.User;
import cn.edu.ahtcm.eurekauserservice.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
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

    @Resource
    private DiscoveryClient discoveryClient;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        User user = userMapper.findById(id).get();
        // 通过服务查询用户角色信息
        ResponseEntity responseEntity = restTemplate.getForEntity("http://role-service/listRoles?id="+id, List.class);
        List<Role> roles = (List<Role>)responseEntity.getBody();
        user.setRoles(roles);
        return user;
    }
}
