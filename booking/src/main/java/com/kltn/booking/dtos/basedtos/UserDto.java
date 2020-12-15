package com.kltn.booking.dtos.basedtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 3:22 PM
 * Filename  : UserDto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String fullName;

    private String address;

    private String phoneNumber;

    private String dateOfBirth;

    private boolean enable;

    private String gender;

    private List<Long>roleIds = new ArrayList<>();
    
    
}
