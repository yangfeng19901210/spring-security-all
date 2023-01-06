package com.yf.springsecurityall.service;

import com.yf.springsecurityall.entity.User;
import com.yf.springsecurityall.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("order:list", "ROLE_ADMIN");
        User user = sysUserMapper.getUserByUsername(username);
        if(user.getUsername().equals("admin")){
            user.setAuthorities(authorities);
        }
        log.info("获取到的登录用户信息为 {}",user);
        return user;
    }
}
