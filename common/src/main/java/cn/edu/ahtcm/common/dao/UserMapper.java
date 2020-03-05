package cn.edu.ahtcm.common.dao;

import cn.edu.ahtcm.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User,Integer> {
}
