package com.kltn.booking.dtos.basedtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoBuyerDto {

    private Long id;

    private String fullName;

    private String email;

    private String numberPhone;

    private String address;
}
