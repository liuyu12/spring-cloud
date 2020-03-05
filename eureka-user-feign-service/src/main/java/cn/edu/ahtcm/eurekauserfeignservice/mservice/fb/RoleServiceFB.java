package cn.edu.ahtcm.eurekauserfeignservice.mservice.fb;

import cn.edu.ahtcm.common.entity.Role;
import cn.edu.ahtcm.eurekauserfeignservice.mservice.RoleService;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
public class RoleServiceFB implements RoleService {
    @Override
    public List<Role> getUserRoles(Integer id) {
        List roles = new LinkedList();
        return roles;
    }
}
