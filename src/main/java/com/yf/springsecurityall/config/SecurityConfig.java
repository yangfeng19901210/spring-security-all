package com.yf.springsecurityall.config;

import com.sun.media.jfxmedia.logging.Logger;
import com.yf.springsecurityall.entity.SysPermission;
import com.yf.springsecurityall.handler.MyAuthenticationSuccessHandler;
import com.yf.springsecurityall.mapper.SysPermissionMapper;
import com.yf.springsecurityall.service.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @projectName: spring-security-all
 * @package: com.yf.springsecurityall.config
 * @className: SecurityConfig
 * @author: yangfeng
 * @description: TODO
 * @date: 2023/1/4 14:59
 * @version: 1.0
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        UserDetails zhangsan = User.builder().username("zhangsan").password(passwordEncoder().encode("123")).authorities("order:list").build();
//        UserDetails lisi = User.builder().username("lisi").password(passwordEncoder().encode("123456")).authorities("order:add").build();
//        manager.createUser(zhangsan);
//        manager.createUser(lisi);
//        return manager;
//    }
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Resource
    private SysPermissionMapper sysPermissionMapper;


    @Resource
    DataSource dataSource;
    @Autowired
    private MyAuthenticationSuccessHandler successHandler;

    @Bean
    JdbcTokenRepositoryImpl jdbcTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
        return authenticationManager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)throws Exception{

        AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizeHttpRequests = http.authorizeHttpRequests();
        //1.查询所有权限,实现动态的资源拦截
        List<SysPermission> allPerms = sysPermissionMapper.getAllPerms();
        allPerms.forEach(perm ->{
            log.info("获取到的资源路径为 {} 对应的权限标识为 {}",perm.getUrl(),perm.getPermTag());
            authorizeHttpRequests.antMatchers(perm.getUrl()).hasAuthority(perm.getPermTag());
        });
        authorizeHttpRequests
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(successHandler)
                .and()
                .rememberMe()
                .tokenRepository(jdbcTokenRepository())
                .tokenValiditySeconds(60*60*12)//设置token过期时间为一天
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .and()
                .userDetailsService(userDetailsService)
                .csrf().disable();
        return http.build();
    }

}
