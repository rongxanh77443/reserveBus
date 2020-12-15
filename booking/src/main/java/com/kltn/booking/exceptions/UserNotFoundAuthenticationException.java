package com.kltn.booking.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:53 PM
 * Filename  : UserNotFoundAuthenticationException
 */
public class UserNotFoundAuthenticationException extends AuthenticationException {
    public UserNotFoundAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserNotFoundAuthenticationException(String msg) {
        super(msg);
    }
}

