package com.kltn.booking.controllers.admin;

import com.kltn.booking.dtos.basedtos.SeatDto;
import com.kltn.booking.entities.Seat;
import com.kltn.booking.securities.seat.SeatService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/seat")
@PreAuthorize("hasRole('ADMIN')")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @ApiOperation(value = "Get all seat phân trang cho admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paging")
    public ResponseEntity<Page<SeatDto>> getAllSeatsPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "name") String column) {
        return new ResponseEntity<>(seatService.getAllSeatsPaging(search, page, size, sort, column), HttpStatus.OK);
    }

    @ApiOperation(value = "Create Seat")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<SeatDto> createSeat(@Valid @RequestBody SeatDto dto){
        return new ResponseEntity<>(seatService.createSeat(dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update Seat")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<SeatDto> updateSeat(@Valid @RequestBody SeatDto dto){
        return new ResponseEntity<>(seatService.updateSeat(dto.getId(), dto),HttpStatus.OK);
    }

    @ApiOperation(value = "change status Seat")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> changStatus(@PathVariable Long id){
        return new ResponseEntity<>(seatService.deleteSeat(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Get Seat by id")
    @GetMapping("/{id}")
    public ResponseEntity<SeatDto> getSeat(@PathVariable Long id){
        return new ResponseEntity<>(seatService.getSeat(id),HttpStatus.OK);
    }
}
