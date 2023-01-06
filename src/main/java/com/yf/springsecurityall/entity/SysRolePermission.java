package com.yf.springsecurityall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @projectName: spring-security-all
 * @package: com.yf.springsecurityall.entity
 * @className: SysRolePermission
 * @author: yangfeng
 * @description: 角色权限关联关系表
 * @date: 2023/1/6 13:59
 * @version: 1.0
 */
@Data
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 740783657512646860L;
    // 角色id
    private Integer roleId;
    // 权限id
    private Integer permId;

}
