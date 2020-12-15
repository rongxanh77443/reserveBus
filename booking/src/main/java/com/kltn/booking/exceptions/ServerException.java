package com.kltn.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:48 PM
 * Filename  : ServerException
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerException extends RuntimeException{
    public ServerException(String message) {
        super(message);
    }
}
