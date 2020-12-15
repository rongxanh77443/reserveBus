package com.kltn.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:07 PM
 * Filename  : InvalidException
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidException extends RuntimeException{
    public InvalidException(String message) {
        super(message);
    }
}
