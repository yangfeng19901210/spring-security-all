package com.yf.springsecurityall.mapper;

import com.yf.springsecurityall.entity.SysRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * (SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-06 11:27:33
 */
@Mapper
public interface SysRoleMapper {
    @Insert("insert into sys_role(role_name,role_desc) values(#{roleName},#{roleDesc})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addRole(SysRole sysRole);


}

