package com.yf.springsecurityall.config;

import com.yf.springsecurityall.handler.MyAuthenticationSuccessHandler;
import com.yf.springsecurityall.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
        http.authorizeRequests()
                //.antMatchers(HttpMethod.GET,"/templates/**").permitAll()
                .antMatchers("/order/list").hasAnyAuthority("order:list")
                .antMatchers("/order/add").hasAnyAuthority("order:add")
                .antMatchers("/order/edit").hasAnyAuthority("order:edit")
                .antMatchers("/order/delete").hasRole("ADMIN")
                .antMatchers("/**").fullyAuthenticated()
                //.anyRequest().authenticated()
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
