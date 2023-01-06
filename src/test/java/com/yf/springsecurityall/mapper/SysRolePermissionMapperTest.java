package com.yf.springsecurityall.mapper;

import com.yf.springsecurityall.entity.SysRolePermission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysRolePermissionMapperTest {

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Test
    void insertBatch() {
        List<SysRolePermission> list = new ArrayList<SysRolePermission>();
        SysRolePermission rp1 = new SysRolePermission();
        rp1.setRoleId(5);
        rp1.setPermId(5);

        SysRolePermission rp2 = new SysRolePermission();
        rp2.setRoleId(5);
        rp2.setPermId(6);

        SysRolePermission rp3 = new SysRolePermission();
        rp3.setRoleId(5);
        rp3.setPermId(7);

        SysRolePermission rp4 = new SysRolePermission();
        rp4.setRoleId(5);
        rp4.setPermId(8);

        SysRolePermission rp5 = new SysRolePermission();
        rp5.setRoleId(5);
        rp5.setPermId(9);
        list.add(rp1);
        list.add(rp2);
        list.add(rp3);
        list.add(rp4);
        list.add(rp5);
        sysRolePermissionMapper.insertBatch(list);

    }
}