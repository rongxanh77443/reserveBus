package com.kltn.booking.dtos.basedtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private Long id;

    private String status;

    private SeatDto seat;


}
