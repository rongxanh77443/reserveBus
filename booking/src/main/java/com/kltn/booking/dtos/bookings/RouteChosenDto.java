package com.kltn.booking.dtos.bookings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteChosenDto {

    private String startingPoint;

    private String destination;

    private String departDate;

}
