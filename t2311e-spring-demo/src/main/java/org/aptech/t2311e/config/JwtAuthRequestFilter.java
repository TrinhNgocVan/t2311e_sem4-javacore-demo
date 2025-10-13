package org.aptech.t2311e.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.aptech.t2311e.service.impl.UserDetailServiceImpl;
import org.aptech.t2311e.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailServiceImpl userDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if(StringUtils.isEmpty(header)  || header.startsWith("Bearer ")){
            // todo : catch exception
        }

        String token  = header.substring(7).trim();
        String username = JWTUtils.getUsernameFromToken(token);
        if(StringUtils.isNotEmpty(username)){
            var userDetail = userDetailService.loadUserByUsername(username);
            // check validate token
            // if check ok  -> load user auth token vao context
        }
        filterChain.doFilter(request,response);
    }
}
