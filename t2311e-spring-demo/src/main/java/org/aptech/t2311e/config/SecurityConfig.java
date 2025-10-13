package org.aptech.t2311e.config;


import org.aptech.t2311e.entity.Role;
import org.aptech.t2311e.entity.constants.RoleEnum;
import org.aptech.t2311e.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private JwtAuthRequestFilter jwtAuthRequestFilter;
    // spring security phan quyen ntn  ??? -> filter chain  : chuoi loc


    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/api/v1/public/**","/api/v1/login/**").permitAll()
                                .requestMatchers("/api/v1/admin/**")
                                .hasRole(RoleEnum.ADMIN.name())
                                .requestMatchers("/api/v1/operator/**")
                                .hasAnyRole(RoleEnum.ADMIN.name(), RoleEnum.OPERATOR.name())
                                .requestMatchers("/api/v1/user/**")
                                .hasAnyRole(RoleEnum.ADMIN.name(), RoleEnum.USER.name())
                                .anyRequest()
                                .authenticated()
                        )
                .userDetailsService(userDetailService)
                // check credential ntn  ????
                .addFilterBefore(jwtAuthRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }




}
