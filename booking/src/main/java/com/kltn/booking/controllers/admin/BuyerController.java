package com.kltn.booking.controllers.admin;



import com.kltn.booking.dtos.basedtos.InfoBuyerDto;
import com.kltn.booking.entities.InfoBuyer;
import com.kltn.booking.securities.infoBuyer.InfoBuyerServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/infoBuyer")
@PreAuthorize("hasRole('ADMIN')")
public class BuyerController {
    
    private final InfoBuyerServiceImpl infoBuyerService;

    public BuyerController(InfoBuyerServiceImpl infoBuyerService) {
        this.infoBuyerService = infoBuyerService;
    }

    @ApiOperation(value = "Get all Information Buyer paging for admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paging")
    public ResponseEntity<Page<InfoBuyer>> getAllInfoBuyersPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "fullName") String column) {
        return new ResponseEntity<>(infoBuyerService.getAllInfoBuyersPaging(search, page, size, sort, column), HttpStatus.OK);
    }

    @ApiOperation(value = "Create Buyer")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<InfoBuyerDto> createInfoBuyer(@Valid @RequestBody InfoBuyerDto dto){
        return new ResponseEntity<InfoBuyerDto>(infoBuyerService.createInfoBuyer(dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update information Buyer")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<InfoBuyerDto> updateInfoBuyer(@Valid @RequestBody InfoBuyerDto dto){
        return new ResponseEntity<>(infoBuyerService.updateInfoBuyer(dto.getId(), dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Get infoBuyer by id")
    @GetMapping("/{id}")
    public ResponseEntity<InfoBuyerDto> getInfoBuyer(@PathVariable Long id){
        return new ResponseEntity<>(infoBuyerService.getInfoBuyer(id),HttpStatus.OK);
    }
}
