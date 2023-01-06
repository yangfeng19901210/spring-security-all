package com.yf.springsecurityall.entity;

import lombok.Data;
/**
 * @projectName: spring-security-all
 * @package: com.yf.springsecurityall.entity
 * @className: SysPermission
 * @author: yangfeng
 * @description: 用来保存资源和权限标识符的关联关系
 * @date: 2023/1/6 13:59
 * @version: 1.0
 */
@Data
public class SysPermission {
	private Integer id;
	// 权限名称
	private String permName;
	// 权限标识
	private String permTag;
	// 请求url
	private String url;
}
