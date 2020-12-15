package com.kltn.booking.controllers.admin;

import com.kltn.booking.dtos.basedtos.RouteDto;
import com.kltn.booking.entities.Route;
import com.kltn.booking.securities.route.RouteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/route")
@PreAuthorize("hasRole('ADMIN')")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @ApiOperation(value = "Get all route phân trang cho admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paging")
    public ResponseEntity<Page<RouteDto>> getAllSeatsPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "startingPoint") String column) {
        return new ResponseEntity<>(routeService.getAllRoutesPaging(search, page, size, sort, column), HttpStatus.OK);
    }

    @ApiOperation(value = "Create Route")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RouteDto> createSeat(@Valid @RequestBody RouteDto dto){
        return new ResponseEntity<>(routeService.createRoute(dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update Route")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<RouteDto> updateSeat(@Valid @RequestBody RouteDto dto){
        return new ResponseEntity<>(routeService.updateRoute(dto.getId(), dto),HttpStatus.OK);
    }

    @ApiOperation(value = "change status route")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> changStatus(@PathVariable Long id){
        return new ResponseEntity<>(routeService.deleteRoute(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Get route by id")
    @GetMapping("/{id}")
    public ResponseEntity<RouteDto> getSeat(@PathVariable Long id){
        return new ResponseEntity<>(routeService.getRoute(id),HttpStatus.OK);
    }
}
