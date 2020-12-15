package com.kltn.booking.securities.ticket;

import com.kltn.booking.conversions.TicketConversion;
import com.kltn.booking.dtos.basedtos.TicketDto;
import com.kltn.booking.entities.Ticket;
import com.kltn.booking.repositories.BillRepository;
import com.kltn.booking.repositories.SeatRepository;
import com.kltn.booking.repositories.SessionRepository;
import com.kltn.booking.repositories.TicketRepository;
import com.kltn.booking.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;

    private final BillRepository billRepository;

    private final SeatRepository seatRepository;

    private final SessionRepository sessionRepository;

    private final TicketConversion ticketConversion;

    public TicketServiceImpl(TicketRepository ticketRepository, BillRepository billRepository, SeatRepository seatRepository, SessionRepository sessionRepository, TicketConversion ticketConversion) {
        this.ticketRepository = ticketRepository;
        this.billRepository = billRepository;
        this.seatRepository = seatRepository;
        this.sessionRepository = sessionRepository;
        this.ticketConversion = ticketConversion;
    }

    @Override
    public Page<TicketDto> getAllTicketsPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        Page<Ticket> ticketPage=ticketRepository.getAllTicketsPaging(search, pageable);
        return ticketPage.map(Ticket->ticketConversion.toTicketDto(Ticket));
    }

    @Override
    public TicketDto createTicket(TicketDto dto) {
        Ticket ticket= ticketConversion.toTicketEntity(dto);
        ticketRepository.save(ticket);
        return ticketConversion.toTicketDto(ticket);
    }

    @Override
    public TicketDto updateTicket(Long id, TicketDto dto) {
        Ticket ticket= ticketRepository.getOne(id);
        ticket=ticketConversion.toTicketEntity(ticket,dto);
        ticketRepository.save(ticket);
        return ticketConversion.toTicketDto(ticket);
    }

    @Override
    public TicketDto getTicket(Long id) {
        Ticket ticket= ticketRepository.getOne(id);
        return ticketConversion.toTicketDto(ticket);
    }

    @Override
    public String deleteTicket(Long id) {
        Ticket ticket= ticketRepository.getOne(id);
        ticket.setStatus("Inactive");
        ticketRepository.save(ticket);
        return "OK";
    }
}
