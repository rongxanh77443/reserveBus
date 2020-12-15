package com.kltn.booking.services;

import com.kltn.booking.entities.User;
import com.kltn.booking.repositories.UserRepository;
import com.kltn.booking.securities.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 12:58 PM
 * Filename  : JwtTokenFilter
 */
public class JwtTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private GoogleUserDetailsService googleUserDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String token = httpServletRequest.getHeader(tokenHeader);
        if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            String userId = jwtTokenUtils.getUsernameFromToken(token);
            long id = Long.parseLong(userId);
            User taiKhoan = userRepository.findById(id).get();
            UserDetails userDetails;
            try {
                userDetails = this.customUserDetailsService.loadUserByUsername(taiKhoan.getUsername());
            } catch (Exception ex) {
                userDetails = this.googleUserDetailsService.loadUserByUsername(taiKhoan.getEmail());
            }
            if (userDetails != null && jwtTokenUtils.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
