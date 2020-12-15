package com.kltn.booking.dtos.basedtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {

    private Long id;

    private String destination;

    private int price;

    private String startingPoint;

    private String timeExpecting;

    private String timeStarting;

    private List<CarDto> carsDto;
}
