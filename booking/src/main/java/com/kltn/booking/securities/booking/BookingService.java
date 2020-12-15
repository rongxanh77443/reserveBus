package com.kltn.booking.securities.booking;

import com.kltn.booking.dtos.basedtos.BillDto;
import com.kltn.booking.dtos.basedtos.InfoBuyerDto;
import com.kltn.booking.dtos.bookings.InfoBusWithRouteChosenDto;
import com.kltn.booking.dtos.bookings.InfoSeatsWithCarChosenDto;
import com.kltn.booking.dtos.bookings.InfoTicketRequest;
import com.kltn.booking.entities.User;

import java.util.List;

public interface BookingService {

    List<InfoBusWithRouteChosenDto> getAllBusesWithRouteChosen(String departDate, String startingPoint, String destination);

    List<InfoSeatsWithCarChosenDto> getAllSeatsWithCarChosen(Long carId);
    
    InfoBuyerDto getInfoBuyerFromUser(Long buyerId);

    User updateUser(InfoBuyerDto BuyerDto);

    List<BillDto> getAllBills(Long idWhomCreateBy);
}
