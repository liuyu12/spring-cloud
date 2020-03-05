package cn.edu.ahtcm.eurekauserservice.service;


import cn.edu.ahtcm.common.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    User findById(int id);
}
