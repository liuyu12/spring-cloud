package cn.edu.ahtcm.userservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "user")
@Entity
public class User {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 加密盐值
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 年龄：1男2女
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 用户状态：1启用; 2禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Transient
    private List<Role> roles;
}
