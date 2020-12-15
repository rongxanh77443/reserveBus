package com.kltn.booking.securities.seat;

import com.kltn.booking.conversions.SeatConversion;
import com.kltn.booking.dtos.basedtos.SeatDto;
import com.kltn.booking.entities.Seat;
import com.kltn.booking.repositories.*;
import com.kltn.booking.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService{

    private final SeatRepository seatRepository;

    private final SeatConversion seatConversion;

    public SeatServiceImpl(SeatRepository seatRepository,SeatConversion seatConversion) {
        this.seatRepository = seatRepository;
        this.seatConversion = seatConversion;
    }


    @Override
    public Page<SeatDto> getAllSeatsPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        Page<Seat> seatPage= seatRepository.getAllSeatsPaging(search, pageable);
        return seatPage.map(Seat->seatConversion.toSeatDto(Seat));
    }

    @Override
    public SeatDto createSeat(SeatDto dto) {
        Seat seat= seatConversion.toSeatEntity(dto);
        seatRepository.save(seat);
        return seatConversion.toSeatDto(seat);
    }

    @Override
    public SeatDto updateSeat(Long id, SeatDto dto) {
        Seat seat= seatRepository.getOne(id);
        seat=seatConversion.toSeatEntity(seat,dto);
        seatRepository.save(seat);
        return seatConversion.toSeatDto(seat);
    }

    @Override
    public SeatDto getSeat(Long id) {
        Seat seat=seatRepository.getOne(id);
        return seatConversion.toSeatDto(seat);
    }

    @Override
    public String deleteSeat(Long id) {
        try {
            seatRepository.delete(seatRepository.getOne(id));
            return "OK";
        }
        catch (Exception e){
            System.out.println("Exception "+e);
            return "NO";
        }
    }


}
