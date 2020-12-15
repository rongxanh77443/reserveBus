package com.kltn.booking.securities.route;

import com.kltn.booking.conversions.RouteConversion;
import com.kltn.booking.dtos.basedtos.RouteDto;
import com.kltn.booking.entities.Route;
import com.kltn.booking.repositories.CarRepository;
import com.kltn.booking.repositories.RouteRepository;
import com.kltn.booking.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final CarRepository carRepository;
    private final RouteConversion routeConversion;

    public RouteServiceImpl(RouteRepository routeRepository, CarRepository carRepository, RouteConversion routeConversion) {
        this.routeRepository = routeRepository;
        this.carRepository = carRepository;
        this.routeConversion = routeConversion;
    }


    @Override
    public Page<RouteDto> getAllRoutesPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        Page<Route> routePage=routeRepository.getAllRoutesPaging(search, pageable);
        return routePage.map(Route->routeConversion.toRouteDto(Route));
    }

    @Override
    public RouteDto createRoute(RouteDto dto) {
        Route route= routeConversion.toRouteEntity(dto);
        routeRepository.save(route);
        return routeConversion.toRouteDto(route);
    }

    @Override
    public RouteDto updateRoute(Long id, RouteDto dto) {
        Route route= routeRepository.getOne(id);
        route=routeConversion.toRouteEntity(route,dto);
        routeRepository.save(route);
        return routeConversion.toRouteDto(route);
    }

    @Override
    public RouteDto getRoute(Long id) {
        Route route=routeRepository.getOne(id);
        return routeConversion.toRouteDto(route);
    }

    @Override
    public String deleteRoute(Long id) {
        try {
            routeRepository.delete(routeRepository.getOne(id));
            return "OK";
        }
        catch (Exception e){
            System.out.println("Exception "+e);
            return "NO";
        }
    }
}
