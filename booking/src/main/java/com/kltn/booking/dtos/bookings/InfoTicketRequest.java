package com.kltn.booking.dtos.bookings;

import com.kltn.booking.dtos.basedtos.InfoBuyerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoTicketRequest {

    private List<Long> seatIds;

    private Long sessionId;

    private int totalPrice;

    private InfoBuyerDto infoBuyerDto;
}
