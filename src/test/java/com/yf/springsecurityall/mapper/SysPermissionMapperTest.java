package com.yf.springsecurityall.mapper;

import com.yf.springsecurityall.entity.SysPermission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysPermissionMapperTest {

    @Resource
    private SysPermissionMapper sysPermissionMapper;
    @Test
    public void testAddPermission(){
        SysPermission permission = new SysPermission();
        permission.setPermName("订单详情");
        permission.setPermTag("order:view");
        permission.setUrl("/order/view");
        sysPermissionMapper.insert(permission);
        System.out.println(permission);
    }

}