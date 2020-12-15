package com.kltn.booking.controllers.admin;

import com.kltn.booking.dtos.UpdatePaymentDto;
import com.kltn.booking.dtos.basedtos.BillDto;
import com.kltn.booking.entities.Bill;
import com.kltn.booking.securities.bill.BillServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/bill")
@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
public class BillController {

    private final BillServiceImpl billService;


    public BillController(BillServiceImpl billService) {
        this.billService = billService;
    }

    @ApiOperation(value = "Get all Bill paging for admin")
    @GetMapping("/paging")
    public ResponseEntity<Page<BillDto>> getAllBillsPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "totalPrice") String column) {
        return new ResponseEntity<>(billService.getAllBillsPaging(search, page, size, sort, column), HttpStatus.OK);
    }

    @ApiOperation(value = "Create Bill")
    @PostMapping
    public ResponseEntity<BillDto> createBill(@Valid @RequestBody BillDto dto){
        return new ResponseEntity<>(billService.createBill(dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update Bill")
    @PutMapping
    public ResponseEntity<BillDto> updateBill(@Valid @RequestBody BillDto dto){
        return new ResponseEntity<>(billService.updateBill(dto.getId(), dto),HttpStatus.OK);
    }

    @ApiOperation(value = "change status Bill")
    @DeleteMapping("/{id}")
    public ResponseEntity<BillDto> changStatus(@PathVariable Long id){
        return new ResponseEntity<>(billService.changeStatus(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Get Bill by id")
    @GetMapping("/{id}")
    public ResponseEntity<BillDto> getBill(@PathVariable Long id){
        return new ResponseEntity<>(billService.getBill(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Update payment")
    @PutMapping("/updatePaymentBill")
    public ResponseEntity<BillDto> updatePaymentBill(@Valid @RequestBody UpdatePaymentDto paymentDto){
        return new ResponseEntity<>(billService.updatePaymentBill(paymentDto),HttpStatus.OK);
    }
}
