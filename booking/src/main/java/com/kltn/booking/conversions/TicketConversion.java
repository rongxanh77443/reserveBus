package com.kltn.booking.conversions;

import com.kltn.booking.dtos.basedtos.TicketDto;
import com.kltn.booking.entities.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketConversion {

    private final SeatConversion seatConversion;

    private final SessionConversion sessionConversion;

    public TicketConversion(SeatConversion seatConversion, SessionConversion sessionConversion) {
        this.seatConversion = seatConversion;
        this.sessionConversion = sessionConversion;
    }

    public Ticket toTicketEntity(TicketDto ticketDto){
        Ticket ticket=new Ticket();
        ticket.setStatus(ticketDto.getStatus());
        ticket.setSeat(seatConversion.toSeatEntity(ticketDto.getSeat()));
        return ticket;
    }
    public TicketDto toTicketDto(Ticket ticket){
        TicketDto ticketDto=new TicketDto();
        if (ticket.getId()!=null)
            ticketDto.setId(ticket.getId());
        ticketDto.setSeat(seatConversion.toSeatDto(ticket.getSeat()));
        ticketDto.setStatus(ticket.getStatus());
        return ticketDto;
    }
    public Ticket toTicketEntity(Ticket ticket,TicketDto ticketDto){
        ticket.setStatus(ticketDto.getStatus());
        ticket.setSeat(seatConversion.toSeatEntity(ticketDto.getSeat()));
        return ticket;
    }
}
