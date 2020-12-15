package com.kltn.booking.controllers.admin;

import com.kltn.booking.dtos.basedtos.CarDto;
import com.kltn.booking.entities.Car;
import com.kltn.booking.securities.car.CarServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/car")
@PreAuthorize("hasRole('ADMIN')")
public class CarController {
    
    private final CarServiceImpl carService;


    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @ApiOperation(value = "Get all Car phân trang cho admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paging")
    public ResponseEntity<Page<Car>> getAllCarsPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "name") String column) {
        return new ResponseEntity<>(carService.getAllCarsPaging(search, page, size, sort, column), HttpStatus.OK);
    }

    @ApiOperation(value = "Create Car")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto dto){
        return new ResponseEntity<>(carService.createCar(dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update Car")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<CarDto> updateCar(@Valid @RequestBody CarDto dto){
        return new ResponseEntity<>(carService.updateCar(dto.getId(), dto),HttpStatus.OK);
    }

    @ApiOperation(value = "change status Car")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> changStatus(@PathVariable Long id){
        return new ResponseEntity<>(carService.deleteCar(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Get Car by id")
    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable Long id){
        return new ResponseEntity<>(carService.getCar(id),HttpStatus.OK);
    }
}
