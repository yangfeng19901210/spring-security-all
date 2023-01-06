package com.yf.springsecurityall.entity;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName: spring-security-all
 * @package: com.yf.springsecurityall.entity
 * @className: SysUserRole
 * @author: yangfeng
 * @description: 用户角色关联关系表
 * @date: 2023/1/6 13:59
 * @version: 1.0
 */
@Data
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 912493171788970160L;

    // 用户id
    private Integer userId;

    //角色id
    private Integer roleId;

}
