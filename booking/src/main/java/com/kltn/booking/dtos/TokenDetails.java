package com.kltn.booking.dtos;

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
 * Time      : 12:58 PM
 * Filename  : TokenDetails
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDetails {
    private String fullName;

    private String token;

    private long expired;

    private List<String> roles = new ArrayList<>();
}
