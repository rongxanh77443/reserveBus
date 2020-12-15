package com.kltn.booking.dtos.bookings;

import com.kltn.booking.dtos.basedtos.CarDto;
import com.kltn.booking.dtos.basedtos.RouteDto;
import com.kltn.booking.dtos.basedtos.SessionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoBusWithRouteChosenDto {

    private Long sessionId;

    private Long routeId;

    private Integer price;

    private String timeStarting;

    private String timeExpecting;

    private CarDto car;

    private Long numberOfAvailableSeat;



}
