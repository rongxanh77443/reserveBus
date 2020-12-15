package com.kltn.booking.securities.booking;

import com.kltn.booking.conversions.BillConversion;
import com.kltn.booking.conversions.CarConversion;
import com.kltn.booking.conversions.SessionConversion;
import com.kltn.booking.dtos.basedtos.BillDto;
import com.kltn.booking.dtos.basedtos.InfoBuyerDto;
import com.kltn.booking.dtos.bookings.InfoBusWithRouteChosenDto;
import com.kltn.booking.dtos.bookings.InfoSeatsWithCarChosenDto;
import com.kltn.booking.entities.Bill;
import com.kltn.booking.entities.User;
import com.kltn.booking.exceptions.DuplicateException;
import com.kltn.booking.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final SeatRepository seatRepository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final BillRepository billRepository;

    private final CarConversion carConversion;

    private final BillConversion billConversion;



    public BookingServiceImpl(SeatRepository seatRepository, CarRepository carRepository, UserRepository userRepository, BillRepository billRepository, BillConversion billConversion, SessionConversion sessionConversion, CarConversion carConversion) {
        this.seatRepository = seatRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.billRepository = billRepository;
        this.billConversion = billConversion;
        this.carConversion = carConversion;
    }


    @Override
    public List<InfoBusWithRouteChosenDto> getAllBusesWithRouteChosen(String departDate, String startingPoint, String destination) {
        List<InfoBusWithRouteChosenDto> listBusesResult = new ArrayList<>();
        for (Object[] objResult : carRepository.getAllInfoCarChosen(startingPoint, destination, departDate)) {
            InfoBusWithRouteChosenDto busResult = new InfoBusWithRouteChosenDto();
            busResult.setSessionId(Long.parseLong(objResult[0].toString()));
            busResult.setRouteId(Long.parseLong(objResult[1].toString()));
            busResult.setPrice(Integer.parseInt(objResult[2].toString()));
            busResult.setTimeStarting(objResult[3].toString());
            busResult.setTimeExpecting(objResult[4].toString());
            busResult.setCar(carConversion.toCarDto(carRepository.findById(Long.parseLong(objResult[5].toString())).get()));
            busResult.setNumberOfAvailableSeat(Long.parseLong(objResult[6].toString()));
            listBusesResult.add(busResult);
        }
        return listBusesResult ;
    }

    @Override
    public List<InfoSeatsWithCarChosenDto> getAllSeatsWithCarChosen(Long carId) {
        List<InfoSeatsWithCarChosenDto> listSeatsResult = new ArrayList<>();

        for (Object[] objResult : seatRepository.getAllSeatsWithChosenCar(carId)) {
            InfoSeatsWithCarChosenDto seatResult = new InfoSeatsWithCarChosenDto();
            seatResult.setSeatId(Long.parseLong(objResult[0].toString()));
            seatResult.setSeatName((String) objResult[1]);
            listSeatsResult.add(seatResult);
        }
        return listSeatsResult;
    }


    @Override
    public InfoBuyerDto getInfoBuyerFromUser(Long buyerId) {
        InfoBuyerDto infoBuyerDto = new InfoBuyerDto();
        User user = userRepository.findById(buyerId).get();
        infoBuyerDto.setFullName(user.getFullName());
        infoBuyerDto.setAddress(user.getAddress());
        infoBuyerDto.setEmail(user.getEmail());
        infoBuyerDto.setNumberPhone(user.getPhoneNumber());
        return infoBuyerDto;
    }

    @Override
    public User updateUser(InfoBuyerDto buyerDto) {
        User user = userRepository.findByEmail(buyerDto.getEmail()).get();
        if (!user.getFullName().equals(buyerDto.getFullName()))
            user.setFullName(buyerDto.getFullName());

        if (!user.getEmail().equals(buyerDto.getEmail())) {
            if (userRepository.existsByEmail(buyerDto.getEmail())) {
                throw new DuplicateException(String.format("Email %s existed: ", buyerDto.getEmail()));
            } else
                user.setAddress(buyerDto.getAddress());
        }
        if (!userRepository.existsByPhoneNumber(buyerDto.getNumberPhone()))
            user.setPhoneNumber(buyerDto.getNumberPhone());
        if (!userRepository.existsByAddress(buyerDto.getAddress()))
            user.setAddress(buyerDto.getAddress());
        userRepository.save(user);
        return user;
    }

    @Override
    public List<BillDto> getAllBills(Long idWhomCreateBy) {
        List<BillDto> listBillsResult= new ArrayList<>();
        for (Bill billResult: billRepository.findByCreatedBy(idWhomCreateBy))
        {
            listBillsResult.add(billConversion.toBillDto(billResult));
        }
        return listBillsResult;
    }
}
