package cn.edu.ahtcm.roleservice.service;

import cn.edu.ahtcm.roleservice.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findUserRoles(int uid);
}
