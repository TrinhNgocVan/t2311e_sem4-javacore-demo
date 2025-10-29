//package org.aptech.t2311e.service.impl;
//
//import lombok.SneakyThrows;
//import org.aptech.t2311e.entity.User;
//import org.aptech.t2311e.exception.BussinessException;
//import org.aptech.t2311e.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//public class UserDetailServiceImpl  implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    // UserDetails  : anh xa cua user trong db vao spring security context
//    @SneakyThrows
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user  = userRepository.findByUsername(username)
//                .orElseThrow(
//                        () -> new BussinessException("User not found", "500", HttpStatus.BAD_REQUEST)
//                );
//        // mapping user in db  -> user of spring security context
//
//        Set<GrantedAuthority> authorities = user.getRoles()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toSet());
//
//
//        return new org.springframework.security.core.userdetails.User(username,user.getPassword()
//        ,authorities);
//    }
//
//    //
//
//
//
//
//
//
//
//}
