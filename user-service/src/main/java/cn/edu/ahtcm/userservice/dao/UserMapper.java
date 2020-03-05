package cn.edu.ahtcm.userservice.dao;

import cn.edu.ahtcm.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User,Integer> {
}
