package com.yf.springsecurityall.handler;

import com.yf.springsecurityall.entity.User;
import com.yf.springsecurityall.mapper.SysUserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

// 认证成功
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Resource
	private SysUserMapper sysUserMapper;

	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication)
			throws IOException, ServletException {
//		System.out.println("用户认证成功");
//		System.out.println(authentication.getPrincipal());
		User user = (User) authentication.getPrincipal();
		sysUserMapper.updateLastLoginTime(new Date(),user.getId());
		res.sendRedirect("/");
	}

}
