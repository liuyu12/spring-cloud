package cn.edu.ahtcm.eurekaroleservice.controller;

import cn.edu.ahtcm.common.entity.Role;
import cn.edu.ahtcm.eurekaroleservice.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {
    @Resource
    private RoleService roleService;

    @GetMapping("listRoles")
    public List<Role> listUserRoles(int id){
        return roleService.findUserRoles(id);
    }

}
