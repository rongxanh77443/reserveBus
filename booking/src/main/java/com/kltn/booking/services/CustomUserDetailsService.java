package com.kltn.booking.services;

import com.kltn.booking.entities.User;
import com.kltn.booking.exceptions.NotFoundException;
import com.kltn.booking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:01 PM
 * Filename  : CustomUserDetailsService
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Tài khoản có tên đăng nhập %s không tồn tại",
                        username)));
        return getUserDetails(user);
    }

    private JwtUserDetails getUserDetails(User user) {
        return new JwtUserDetails(
                user.getId().toString(),
                user.getPassword(),
                user.getFullName(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()),
                user.isEnable()
        );
    }
}
