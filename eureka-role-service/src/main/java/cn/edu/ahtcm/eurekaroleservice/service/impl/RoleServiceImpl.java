package cn.edu.ahtcm.eurekaroleservice.service.impl;

import cn.edu.ahtcm.common.dao.RoleMapper;
import cn.edu.ahtcm.common.entity.Role;
import cn.edu.ahtcm.eurekaroleservice.service.RoleService;
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
        // 设置随机延时
        if(Math.random() > 0.6){
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
        return roleMapper.listUserRoles(uid);
    }
}
