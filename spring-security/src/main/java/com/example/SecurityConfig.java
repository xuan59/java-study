package com.example;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        http.csrf().disable(); //防止网站工具
        /*
        *    loginPage:指定自己的login界面
        *    loginProcessingUrl：登录后的请求
        *
        * */
        http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login"); //没有权限跳转登录页面

        http.logout().logoutSuccessUrl("/login"); //注销

       //http.rememberMe().rememberMeParameter("remember"); //记住我
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lx").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3").and()
                .withUser("jj").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2").and()
                .withUser("yy").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");


        /*
         *   使用数据库
         * */

//        User.UserBuilder user = User.withDefaultPasswordEncoder();
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser(user.username("user").password("password").roles("level"))
//                .withUser(user.username("user").password("password").roles("level","level2"));



    }


}
