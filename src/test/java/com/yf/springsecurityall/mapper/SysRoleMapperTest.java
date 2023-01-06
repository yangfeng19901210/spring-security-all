package com.yf.springsecurityall.mapper;

import com.yf.springsecurityall.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysRoleMapperTest {

    @Resource
    private SysRoleMapper sysRoleMapper;
    @Test
    public void testAddRole(){
        SysRole role = new SysRole();
        role.setRoleName("common_salesman");
        role.setRoleDesc("普通销售");
        sysRoleMapper.addRole(role);
        System.out.println(role);
    }

}