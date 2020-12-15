package com.kltn.booking.dtos.basedtos;

import com.kltn.booking.conversions.BillConversion;
import com.kltn.booking.conversions.BuyerConversion;
import com.kltn.booking.conversions.TicketConversion;
import com.kltn.booking.entities.Bill;
import com.kltn.booking.entities.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {

    private Long id;

    private int status;

    private int totalPrice;

    private InfoBuyerDto buyer;

    private Collection<TicketDto> tickets;

    private String payment;

    private SessionDto session;
}
