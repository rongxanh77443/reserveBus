package com.kltn.booking.securities.seat;

import com.kltn.booking.dtos.basedtos.SeatDto;
import com.kltn.booking.entities.Seat;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SeatService {

    Page<SeatDto> getAllSeatsPaging(String search, int page, int size, String sort, String column);

    SeatDto createSeat(SeatDto dto);

    SeatDto updateSeat(Long id, SeatDto dto);

    SeatDto getSeat(Long id);

    String deleteSeat(Long id);
}
