package com.kltn.booking.securities.route;

import com.kltn.booking.dtos.basedtos.RouteDto;
import com.kltn.booking.entities.Route;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RouteService {
    Page<RouteDto> getAllRoutesPaging(String search, int page, int size, String sort, String column);

    RouteDto createRoute(RouteDto dto);

    RouteDto updateRoute(Long id, RouteDto dto);

    RouteDto getRoute(Long id);

    String deleteRoute(Long id);
}
