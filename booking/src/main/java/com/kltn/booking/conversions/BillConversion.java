package com.kltn.booking.conversions;

import com.kltn.booking.dtos.basedtos.BillDto;
import com.kltn.booking.dtos.basedtos.TicketDto;
import com.kltn.booking.entities.Bill;
import com.kltn.booking.entities.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class BillConversion {

    private final BuyerConversion buyerConversion;

    private final  TicketConversion ticketConversion;

    private final SessionConversion sessionConversion;

    public BillConversion(BuyerConversion buyerConversion, TicketConversion ticketConversion, SessionConversion sessionConversion) {
        this.buyerConversion = buyerConversion;
        this.ticketConversion = ticketConversion;
        this.sessionConversion = sessionConversion;
    }

    public Bill toBillEntity(BillDto billDto){
        Bill bill= new Bill();
        bill.setBuyer(buyerConversion.toInfoBuyerEntity(billDto.getBuyer()));
        bill.setPayment(billDto.getPayment());
        bill.setStatus(billDto.getStatus());
        bill.setTotalPrice(billDto.getTotalPrice());
        bill.setSession(sessionConversion.toSessionEntity(billDto.getSession()));
        Collection<Ticket> tickets= new ArrayList<>();
        for (TicketDto ticketdto: billDto.getTickets())
        {
            tickets.add(ticketConversion.toTicketEntity(ticketdto));
        }
        bill.setTickets(tickets);
        return bill;
    }
    public BillDto toBillDto(Bill bill){
        BillDto billDto=new BillDto();
        if (bill.getId()!=null)
            billDto.setId(bill.getId());
        billDto.setBuyer(buyerConversion.toInfoBuyerDto(bill.getBuyer()));
        billDto.setPayment(bill.getPayment());
        billDto.setStatus(bill.getStatus());
        billDto.setTotalPrice(bill.getTotalPrice());
        billDto.setSession(sessionConversion.toSessionDto(bill.getSession()));
        Collection<TicketDto> ticketDtos=new ArrayList<>();
        for (Ticket ticket:bill.getTickets())
        {
            ticketDtos.add(ticketConversion.toTicketDto(ticket));
        }
        billDto.setTickets(ticketDtos);
        return billDto;
    }
    public Bill toEntityBill(Bill bill,BillDto billDto){
        bill.setBuyer(buyerConversion.toInfoBuyerEntity(billDto.getBuyer()));
        bill.setPayment(billDto.getPayment());
        bill.setStatus(billDto.getStatus());
        bill.setSession(sessionConversion.toSessionEntity(billDto.getSession()));
        bill.setTotalPrice(billDto.getTotalPrice());
        Collection<Ticket> tickets= new ArrayList<>();
        for (TicketDto ticketdto: billDto.getTickets())
        {
            tickets.add(ticketConversion.toTicketEntity(ticketdto));
        }
        bill.setTickets(tickets);
        return bill;
    }
}
