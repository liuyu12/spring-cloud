package cn.edu.ahtcm.roleservice.service.impl;

import cn.edu.ahtcm.roleservice.dao.RoleMapper;
import cn.edu.ahtcm.roleservice.entity.Role;
import cn.edu.ahtcm.roleservice.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findUserRoles(int uid) {

        return roleMapper.listUserRoles(uid);
    }
}
