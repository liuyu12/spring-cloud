package cn.edu.ahtcm.common.dao;

import cn.edu.ahtcm.common.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleMapper extends JpaRepository<Role,Integer> {

    @Query(value = "select * from user u inner join user_role ur on ur.user_id = u.id inner join role r on r.id = ur.role_id where u.id = :uid",nativeQuery = true)
    List<Role> listUserRoles(@Param("uid") Integer uid);
}
