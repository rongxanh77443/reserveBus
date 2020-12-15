package com.kltn.booking.services.provider;

import com.kltn.booking.services.GoogleUserDetailsService;
import com.kltn.booking.services.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 12:58 PM
 * Filename  : UserAuthenticationProvider
 */
public class UserAuthenticationProvider implements AuthenticationProvider {

    private final CustomUserDetailsService customUserDetailsService;

    private final GoogleUserDetailsService googleUserDetailsService;

    public UserAuthenticationProvider(CustomUserDetailsService customUserDetailsService,
                                      GoogleUserDetailsService googleUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
        this.googleUserDetailsService = googleUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserAuthenticationToken customAuth = (UserAuthenticationToken) authentication;
        String email = customAuth.getName();
        String password = customAuth.getCredentials() == null ? null : customAuth.getCredentials().toString();
        boolean verifyCredentials = Boolean.parseBoolean(customAuth.isVerifyCredentials().toString());
        UserDetails userDetails;
        try {
            userDetails = customUserDetailsService.loadUserByUsername(email);
        } catch (Exception ex) {
            userDetails = googleUserDetailsService.loadUserByUsername(email);
        }
        if (!userDetails.isEnabled())
            throw new BadCredentialsException("Tài khoản đã bị khóa ");
        if (verifyCredentials) {
            assert password != null;
            if (password.equals(userDetails.getPassword())) {
                return new UserAuthenticationToken(email, password, verifyCredentials, userDetails.getAuthorities());
            } else {
                throw new BadCredentialsException("Mật khẩu không chính xác");
            }
        } else {
            return new UserAuthenticationToken(email, "N/A", verifyCredentials, userDetails.getAuthorities());
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserAuthenticationToken.class);
    }
}
