package com.kltn.booking.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 12:58 PM
 * Filename  : JwtUserDetails
 */
public class JwtUserDetails implements UserDetails {

    private final String userName;

    private final String passWord;

    private final String fullName;

    private final Collection<? extends GrantedAuthority> authorities;

    private final boolean active;

    public JwtUserDetails(String userName, String passWord, String fullName,
                          Collection<? extends GrantedAuthority> authorities, boolean active) {
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.authorities = authorities;
        this.active = active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}