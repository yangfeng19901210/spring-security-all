package com.yf.springsecurityall.mapper;

import com.yf.springsecurityall.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-05 14:14:28
 */
@Mapper
public interface SysUserMapper {

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(User sysUser);
    /**
     * @Author yangfeng
     * @Description //根据用户名查询用户信息
     * @Date 15:35 2023/1/5
     * @param username: 用户名查询参数
     * @return com.yf.springsecurityall.entity.User
     */
    //@Select("select * from sys_user where username = #{username}")
    User getUserByUsername(@Param("username") String username);
    @Update("update sys_user set last_login_time = #{lastLoginTime} where id = #{id}")
    int updateLastLoginTime(@Param("lastLoginTime")Date lastLoginTime,@Param("id") Integer id);



}

