package com.kltn.booking.dtos.basedtos;

import com.kltn.booking.dtos.basedtos.CarDto;
import com.kltn.booking.dtos.basedtos.RouteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {

    private Long id;

    private RouteDto routeDto;

    private String departDate;
}
