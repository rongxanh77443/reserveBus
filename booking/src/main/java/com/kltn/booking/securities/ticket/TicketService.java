package com.kltn.booking.securities.ticket;

import com.kltn.booking.dtos.basedtos.TicketDto;
import com.kltn.booking.entities.Ticket;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TicketService {

    Page<TicketDto> getAllTicketsPaging(String search, int page, int size, String sort, String column);

    TicketDto createTicket(TicketDto dto);

    TicketDto updateTicket(Long id, TicketDto dto);

    TicketDto getTicket(Long id);

    String deleteTicket(Long id);
}
