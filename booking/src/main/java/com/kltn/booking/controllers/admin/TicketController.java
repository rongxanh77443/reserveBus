package com.kltn.booking.controllers.admin;

import com.kltn.booking.dtos.basedtos.TicketDto;
import com.kltn.booking.entities.Ticket;
import com.kltn.booking.securities.ticket.TicketServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/ticket")
@PreAuthorize("hasRole('ADMIN')")
public class TicketController {
    
    private final TicketServiceImpl ticketService;


    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @ApiOperation(value = "Get all Ticket paging for admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paging")
    public ResponseEntity<Page<TicketDto>> getAllTicketsPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "status") String column) {
        return new ResponseEntity<>(ticketService.getAllTicketsPaging(search, page, size, sort, column), HttpStatus.OK);
    }

    @ApiOperation(value = "Create Ticket")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@Valid @RequestBody TicketDto dto){
        return new ResponseEntity<>(ticketService.createTicket(dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update Ticket")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<TicketDto> updateTicket(@Valid @RequestBody TicketDto dto){
        return new ResponseEntity<>(ticketService.updateTicket(dto.getId(), dto),HttpStatus.OK);
    }

    @ApiOperation(value = "change status Ticket")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> changStatus(@PathVariable Long id){
        return new ResponseEntity<>(ticketService.deleteTicket(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Get Ticket by id")
    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicket(@PathVariable Long id){
        return new ResponseEntity<>(ticketService.getTicket(id),HttpStatus.OK);
    }
}
