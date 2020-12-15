package com.kltn.booking.securities.bill;

import com.kltn.booking.dtos.UpdatePaymentDto;
import com.kltn.booking.dtos.basedtos.BillDto;
import com.kltn.booking.entities.Bill;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BillService {

    Page<BillDto> getAllBillsPaging(String search, int page, int size, String sort, String column);

    BillDto createBill(BillDto dto);

    BillDto updateBill(Long id, BillDto dto);

    BillDto getBill(Long id);

    BillDto changeStatus(Long id);

    BillDto updatePaymentBill(UpdatePaymentDto paymentDto);
}
