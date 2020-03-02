package com.nssol.web.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.nssol.model.SecurityUser;
import com.nssol.web.common.constants.ResultCodeEnum;
import com.nssol.web.common.util.ExceptionUtil;
import com.nssol.web.common.util.JwtUtils;
import com.nssol.web.common.util.ResponseUtil;
import com.nssol.config.RsaKeyProperties;
import com.nssol.web.security.factory.SecurityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private RsaKeyProperties prop;

    public JwtLoginFilter(AuthenticationManager authenticationManager, RsaKeyProperties prop) {
        this.authenticationManager = authenticationManager;
        this.prop = prop;
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            SecurityUser securityUser = new ObjectMapper().readValue(request.getInputStream(), SecurityUser.class);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(securityUser.getUsername(), securityUser.getPassword());
            return authenticationManager.authenticate(authRequest);
        } catch (BadCredentialsException | InternalAuthenticationServiceException |IOException e) {
            // 密码错误|账号错误|请求流读取问题,记录日志
            log.error(ExceptionUtil.getMessage(e));
            ResponseUtil.response(response,HttpServletResponse.SC_OK, ResultCodeEnum.ACCOUNT_PASSWORD_ERROR);
        }
        return null;
    }

    /**
     * 用户登录成功，返回Token
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Transactional
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // 登录认证通过，返回用户明和token
        SecurityUser securityUser = SecurityFactory.login((SecurityUser) authResult.getPrincipal());
        String token = JwtUtils.generateTokenExpireInMinutes(securityUser, prop.getPrivateKey(), 24 * 60);
        securityUser.setToken("Bearer" + token);
        ResponseUtil.response(response,HttpServletResponse.SC_OK,ResultCodeEnum.AUTHENTICATE_SUCCESS,securityUser);
    }

}
