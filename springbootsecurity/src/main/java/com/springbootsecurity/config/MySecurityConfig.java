package com.springbootsecurity.config;

import com.springbootsecurity.security.MyPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制授权规则
        http.authorizeRequests().antMatchers("/").permitAll()//所有人都能访问
                .antMatchers("/level1/**").hasRole("VIP1")//VIP1只能访问level1下面的
                .antMatchers("/level2/**").hasRole("VIP2")//VIP2只能访问level2下面的
                .antMatchers("/level3/**").hasRole("VIP3");//VIP3只能访问level3下面的

        //开启自动配置的登录功能
        //没有权限会自动跳转到login，
        http.formLogin().usernameParameter("name").passwordParameter("password").loginPage("/login"); //跳转到自己的login
        //http.formLogin(); //跳转到自带的login

        //开启自动配置的注销功能
        //当用户访问logout时就进行注销，清空session
        //http.logout(); //注销成功跳转到登录页面
        http.logout().logoutSuccessUrl("/"); //设置注销成功后跳转首页

        //开启记住我功能
        //http.rememberMe(); 自带
        http.rememberMe().rememberMeParameter("remember");

    }
    //认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("guaiguai").password("123456").roles("VIP1","VIP2").and()
                .withUser("baobao").password("123456").roles("VIP3").and()
                .withUser("xiannv").password("111111").roles("VIP2","VIP3");

    }
}
