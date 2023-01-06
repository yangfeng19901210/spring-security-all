package com.yf.springsecurityall.mapper;

import com.yf.springsecurityall.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SysPermission)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-06 13:54:12
 */
@Mapper
public interface SysPermissionMapper {

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    int insert(SysPermission sysPermission);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermission queryById(Integer id);
    /**
     * @Author @yangfeng
     * @Description //查看所有权限
     * @Date 16:39 2023/1/6
     * @return java.util.List<com.yf.springsecurityall.entity.SysPermission>
     **/
    List<SysPermission> getAllPerms();


}

