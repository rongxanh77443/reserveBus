package com.kltn.booking.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:17 PM
 * Filename  : LoginDto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String username;

    private String password;
}
