package com.kltn.booking.controllers;

import com.kltn.booking.dtos.basedtos.BillDto;
import com.kltn.booking.dtos.basedtos.InfoBuyerDto;
import com.kltn.booking.dtos.basedtos.LocationDto;
import com.kltn.booking.dtos.bookings.*;
import com.kltn.booking.entities.Location;
import com.kltn.booking.entities.User;
import com.kltn.booking.securities.bill.BillServiceImpl;
import com.kltn.booking.securities.booking.BookingService;
import com.kltn.booking.securities.location.LocationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class BookingController {

    private final LocationService locationService;

    private final BookingService bookingService;

    private final BillServiceImpl billService;

    public BookingController(LocationService locationService, BookingService bookingService, BillServiceImpl billService) {
        this.locationService = locationService;
        this.bookingService = bookingService;
        this.billService = billService;
    }

    @ApiOperation(value = "Get all locations")
    @GetMapping(value = "/getLocations")
    public ResponseEntity<List<LocationDto>> getAllLocations() {
        return new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all cars and routes with location chosen")
    @GetMapping(value = "/getRoutes")
    public ResponseEntity<List<InfoBusWithRouteChosenDto>> getAllCarsWithLocation(@RequestParam(name = "departDate", defaultValue = "") String departDate, @RequestParam(name = "startingPoint", defaultValue = "") String startingPoint, @RequestParam(name = "destination", defaultValue = "") String destination) {

        return new ResponseEntity<>(bookingService.getAllBusesWithRouteChosen(departDate, startingPoint, destination), HttpStatus.OK);

    }

    @ApiOperation(value = "Get information of seat by car chosen")
    @GetMapping(value = "/getSeats")
    public ResponseEntity<List<InfoSeatsWithCarChosenDto>> getAllSeatsWithCars(@RequestParam(name = "carId",defaultValue = "") Long carId) {
        return new ResponseEntity<>(bookingService.getAllSeatsWithCarChosen(carId), HttpStatus.OK);
    }

    @ApiOperation(value = "Get information if buyer has account")
    @GetMapping(value = "/getInfoBuyerFromUser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<InfoBuyerDto> getInfoBuyerFromUser(@RequestParam(name = "userId") Long userId) {
        return new ResponseEntity<>(bookingService.getInfoBuyerFromUser(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "update information user")
    @PutMapping(value = "/updateInfoUser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> updateUser(@Valid @RequestBody InfoBuyerDto buyerDto) {
        return new ResponseEntity<>(bookingService.updateUser(buyerDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Confirm tickets")
    @PostMapping(value = "/confirmTickets")
    public ResponseEntity<BillDto> confirmTicket(@Valid @RequestBody BillDto billDto) {
        return new ResponseEntity<>(billService.createBill(billDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all bill of manager or user")
    @GetMapping(value = "/getAllBills/{idWhomCreateBy}")
    @PreAuthorize("HasRole('MANAGER') or HasRole('USER')")
    public ResponseEntity<List<BillDto>> getAllBills(@PathVariable Long idWhomCreateBy) {
        return new ResponseEntity<>(bookingService.getAllBills(idWhomCreateBy), HttpStatus.OK);
    }
}
