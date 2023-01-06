package com.yf.springsecurityall.mapper;

import com.yf.springsecurityall.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysUserMapperTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void insert() {
        User user = new User();
        user.setUsername("wangwu");
        user.setRealname("王五");
        user.setPassword(passwordEncoder.encode("123"));
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setCreateDate(new Date());
        sysUserMapper.insert(user);
    }
}