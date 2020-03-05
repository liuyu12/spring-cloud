package cn.edu.ahtcm.eurekauserfeignservice.service.impl;

import cn.edu.ahtcm.common.dao.UserMapper;
import cn.edu.ahtcm.common.entity.Role;
import cn.edu.ahtcm.common.entity.User;
import cn.edu.ahtcm.eurekauserfeignservice.mservice.RoleService;import cn.edu.ahtcm.eurekauserfeignservice.service.UserService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleService roleService;

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
        List<Role> roles = roleService.getUserRoles(id);
        user.setRoles(roles);
        return user;
    }
}
