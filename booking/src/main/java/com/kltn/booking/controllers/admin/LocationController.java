package com.kltn.booking.controllers.admin;

import com.kltn.booking.dtos.basedtos.LocationDto;
import com.kltn.booking.entities.Location;
import com.kltn.booking.securities.location.LocationServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/location")
@PreAuthorize("hasRole('ADMIN')")
public class LocationController {

    private final LocationServiceImpl locationService;


    public LocationController(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }

    @ApiOperation(value = "Get all Location phân trang cho admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paging")
    public ResponseEntity<Page<Location>> getAllLocationsPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "name") String column) {
        return new ResponseEntity<>(locationService.getAllLocationsPaging(search, page, size, sort, column), HttpStatus.OK);
    }

    @ApiOperation(value = "Create Location")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<LocationDto> createLocation(@Valid @RequestBody LocationDto dto){
        return new ResponseEntity<>(locationService.createLocation(dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update Location")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<LocationDto> updateLocation(@Valid @RequestBody LocationDto dto){
        return new ResponseEntity<>(locationService.updateLocation(dto.getId(), dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Location")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id){
        return new ResponseEntity<>(locationService.deleteLocation(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Get Location by id")
    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable Long id){
        return new ResponseEntity<>(locationService.getLocation(id),HttpStatus.OK);
    }
}
