package com.kltn.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:07 PM
 * Filename  : DuplicateException
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateException extends RuntimeException{
    public DuplicateException(String message) {
        super(message);
    }
}
