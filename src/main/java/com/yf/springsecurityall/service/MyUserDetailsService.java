package com.yf.springsecurityall.service;

import com.yf.springsecurityall.entity.SysPermission;
import com.yf.springsecurityall.entity.User;
import com.yf.springsecurityall.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: spring-security-all
 * @package: com.yf.springsecurityall.service
 * @className: MyUserDetailsService
 * @author: yangfeng
 * @description: TODO
 * @date: 2023/1/5 11:20
 * @version: 1.0
 */
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        User user = sysUserMapper.getUserByUsername(username);
        //查询用户对应的权限
        List<SysPermission> perms = sysUserMapper.getPermsByUsername(username);
        System.out.println(perms);
        perms.forEach(perm ->{
            authorities.add(new SimpleGrantedAuthority(perm.getPermTag()));
        });
        //设置用户权限
        user.setAuthorities(authorities);
        log.info("获取到的登录用户信息为 {}",user);
        return user;
    }
}
