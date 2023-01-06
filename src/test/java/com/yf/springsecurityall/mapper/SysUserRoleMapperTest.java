package com.yf.springsecurityall.mapper;

import com.yf.springsecurityall.entity.SysUserRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysUserRoleMapperTest {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Test
    void insertBatch() {
        List<SysUserRole> list = new ArrayList<SysUserRole>();
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(1);
        userRole.setRoleId(5);
        list.add(userRole);
        sysUserRoleMapper.insertBatch(list);
    }
}