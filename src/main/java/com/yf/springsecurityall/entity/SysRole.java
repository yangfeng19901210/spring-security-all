package com.yf.springsecurityall.entity;

import lombok.Data;

// 角色信息表
@Data
public class SysRole {
	private Integer id;
	private String roleName;
	private String roleDesc;
}
