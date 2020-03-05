package cn.edu.ahtcm.eurekaroleservice.service;


import cn.edu.ahtcm.common.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findUserRoles(int uid);
}
