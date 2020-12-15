package com.kltn.booking.conversions;

import com.kltn.booking.dtos.basedtos.SeatDto;
import com.kltn.booking.entities.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatConversion {

    private final CarConversion carConversion;

    public SeatConversion(CarConversion carConversion) {
        this.carConversion = carConversion;
    }

    public Seat toSeatEntity(SeatDto seatDto){
        Seat seat=new Seat();
        seat.setName(seatDto.getName());
        seat.setCar(carConversion.toCarEntity(seatDto.getCar()));
        return seat;
    }
    public SeatDto toSeatDto(Seat seat){
        SeatDto seatDto=new SeatDto();
        if (seat.getId()!=null)
            seatDto.setId(seat.getId());
        seatDto.setName(seat.getName());
        seatDto.setCar(carConversion.toCarDto(seat.getCar()));
        return seatDto;
    }
    public Seat toSeatEntity(Seat seat, SeatDto seatDto){
        seat.setCar(carConversion.toCarEntity(seatDto.getCar()));
        seat.setName(seatDto.getName());
        return seat;
    }
}
