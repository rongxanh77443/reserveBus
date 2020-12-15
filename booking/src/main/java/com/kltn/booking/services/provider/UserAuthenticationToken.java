package com.kltn.booking.services.provider;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 12:58 PM
 * Filename  : UserAuthenticationToken
 */
public class UserAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;

    private Object credentials;

    private Object verifyCredentials;

    public UserAuthenticationToken(Object principal, Object credentials, Object verifyCredentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        this.verifyCredentials = verifyCredentials;
        super.setAuthenticated(false);
    }

    public UserAuthenticationToken(Object principal, Object credentials, Object verifyCredentials, Collection<? extends GrantedAuthority > authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        this.verifyCredentials = verifyCredentials;
        super.setAuthenticated(true);
    }

    public Object getCredentials() {
        return this.credentials;
    }

    public Object getPrincipal() {
        return this.principal;
    }

    public Object isVerifyCredentials() {
        return this.verifyCredentials;
    }


    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }
}