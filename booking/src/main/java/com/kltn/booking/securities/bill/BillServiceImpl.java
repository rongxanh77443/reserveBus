package com.kltn.booking.securities.bill;

import com.kltn.booking.conversions.BillConversion;
import com.kltn.booking.conversions.TicketConversion;
import com.kltn.booking.dtos.UpdatePaymentDto;
import com.kltn.booking.dtos.basedtos.BillDto;
import com.kltn.booking.dtos.basedtos.TicketDto;
import com.kltn.booking.entities.Bill;
import com.kltn.booking.repositories.BillRepository;
import com.kltn.booking.repositories.TicketRepository;
import com.kltn.booking.securities.ticket.TicketServiceImpl;
import com.kltn.booking.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImpl implements BillService{


    private final BillRepository billRepository;


    private final BillConversion billConversion;

    private final TicketServiceImpl ticketService;

    public BillServiceImpl(BillRepository billRepository,BillConversion billConversion,TicketServiceImpl ticketService) {
        this.billRepository=billRepository;
        this.billConversion = billConversion;
        this.ticketService = ticketService;
    }

    @Override
    public Page<BillDto> getAllBillsPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        Page<Bill> pageResult=billRepository.getAllBillsPaging(search, pageable);
        return pageResult.map(Bill->billConversion.toBillDto(Bill));
    }

    @Override
    public BillDto createBill(BillDto dto) {
        Bill bill= billConversion.toBillEntity(dto);
        billRepository.save(bill);
        for(TicketDto ticketDto:dto.getTickets())
        ticketService.createTicket(ticketDto);
        return billConversion.toBillDto(bill);
    }

    @Override
    public BillDto updateBill(Long id, BillDto dto) {
        Bill bill= billRepository.getOne(id);
        bill=billConversion.toEntityBill(bill,dto);
        billRepository.save(bill);
        for(TicketDto ticketDto:dto.getTickets())
            ticketService.updateTicket(ticketDto.getId(),ticketDto);
        return billConversion.toBillDto(bill);
    }

    @Override
    public BillDto getBill(Long id) {
        Bill bill= billRepository.getOne(id);
        return billConversion.toBillDto(bill);
    }

    @Override
    public BillDto changeStatus(Long id) {
        Bill bill= billRepository.getOne(id);
        bill.setStatus(0);
        billRepository.save(bill);
        return billConversion.toBillDto(bill);
    }

    @Override
    public BillDto updatePaymentBill(UpdatePaymentDto paymentDto) {
        Bill bill= billRepository.getOne(paymentDto.getId());
        bill.setPayment(paymentDto.getPayment());
        billRepository.save(bill);
        return billConversion.toBillDto(bill);
    }

}
