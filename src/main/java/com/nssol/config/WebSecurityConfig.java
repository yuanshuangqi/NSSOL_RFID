package com.nssol.config;


import com.nssol.web.system.service.user.IUserService;
import com.nssol.web.security.filter.JwtLoginFilter;
import com.nssol.web.security.filter.JwtVerifyFilter;
import com.nssol.web.util.user.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private IUserService userService;
    @Resource
    private RsaKeyProperties rsaKeyProperties;
    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/getDownLoadFiles",
                        "/getMaxFileName","/uploadLog","/getOrderDetailListByPoSku","/getOrderDetailListBysku",
                        "/getSkuListByOrderNo","/getSkuListByOrderNo","/getBaggingByToday","/getBaggingList","/getBaggingListPage",
                        "/getOrderBySkuCode","/getBasicInfo","/deleteMetalcheckData","/getMetalcheckByToday","/getMetalcheckList",
                        "/getMetalcheckListPage","/getOrderAutoBySkuCode","/getSaveMetalCheckList","/getSensitivityList",
                        "/getEnableAddress","/getMstDictionaryList","/setMstDictionaryList","/getOrderTaggingBySkuCode",
                        "/getTaggingByToday","/getTaggingList","/getTaggingListPage","/getUserByIDCard","/getUserList",
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources",
                        "/configuration/security",
                        "/swagger-ui.html", "/webjars/**",
                        "/swagger-resources/configuration/ui",
                        "/webjars/springfox-swagger-ui/**",
                        "/backUpBaggingAndMetalcheck"); // #3
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                // 设置UserDetailsService
                .userDetailsService(this.userDetailsService)
                // 使用BCrypt进行密码的hash
                .passwordEncoder(new PasswordEncoder(){
                    public String encode(CharSequence rawPassword) {
                        return UserUtil.getEncryptPassword((String)rawPassword);
                     }
                     public boolean matches(CharSequence rawPassword, String encodedPassword) {//rawPassword用户输入的，encodedPassword数据库查出来的
                        return encodedPassword.equals(UserUtil.getEncryptPassword((String)rawPassword));
                    }}
                );
    }
    // 装载BCrypt密码编码器
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                csrf().disable()
                //采用JWT,所以不需要Session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources",
                        "/configuration/security",
                        "/swagger-ui.html", "/webjars/**",
                        "/swagger-resources/configuration/ui",
                        "/webjars/springfox-swagger-ui/**").permitAll()


                // 禁用其余所有请求
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtLoginFilter(super.authenticationManager(),rsaKeyProperties))
                .addFilter(new JwtVerifyFilter(super.authenticationManager(),rsaKeyProperties,userService));

//        //允许所有用户访问"/"和"/login"
//        httpSecurity.authorizeRequests()
//                // 所有用户均可访问的资源
//                //.antMatchers("/", "/home").permitAll()
//                .antMatchers("/css/**", "/js/**","/img/**", "/webjars/**", "**/favicon.ico",
//                        "/login.html").permitAll()
//                //其他地址的访问均需验证权限
//                .anyRequest().authenticated()
//                // ROLE_USER的权限才能访问的资源
//                //.antMatchers("/user/**").hasRole("USER")
//                .and()
//                .formLogin()
//                //指定登录页是"/login"
//                .loginPage("/login")
//                .defaultSuccessUrl("/index")//登录成功后默认跳转到"/hello"
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login")//退出登录后的默认url是"/home"
//                .permitAll();
        //禁用缓存
        httpSecurity.headers().cacheControl();
    }


}
