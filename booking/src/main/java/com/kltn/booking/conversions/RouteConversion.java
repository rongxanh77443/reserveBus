package com.kltn.booking.conversions;

import com.kltn.booking.dtos.basedtos.CarDto;
import com.kltn.booking.dtos.basedtos.RouteDto;
import com.kltn.booking.entities.Car;
import com.kltn.booking.entities.Route;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class RouteConversion {
    private final CarConversion carConversion;

    public RouteConversion(CarConversion carConversion) {
        this.carConversion = carConversion;
    }
    public Route toRouteEntity(RouteDto routeDto){
        Route route=new Route();
        route.setTimeStarting(routeDto.getTimeStarting());
        route.setTimeExpecting(routeDto.getTimeExpecting());
        route.setPrice(routeDto.getPrice());
        route.setDestination(routeDto.getDestination());
        route.setStartingPoint(routeDto.getStartingPoint());
        route.setCars((Set<Car>) carConversion.toCarEntity(routeDto.getCarsDto().iterator().next()));
        return route;
    }
    public RouteDto toRouteDto(Route route){
        RouteDto routeDto=new RouteDto();
        if (route.getId()!=null){
            routeDto.setId(route.getId());
        }
        routeDto.setDestination(route.getDestination());
        routeDto.setStartingPoint(route.getStartingPoint());
        routeDto.setTimeExpecting(route.getTimeExpecting());
        routeDto.setTimeStarting(route.getTimeStarting());
        routeDto.setPrice(route.getPrice());
        List<CarDto> carDtoList=new ArrayList<>();
        for (Car car: route.getCars())
            carDtoList.add(carConversion.toCarDto(car));
        routeDto.setCarsDto(carDtoList);
        return routeDto;
    }
    public Route toRouteEntity(Route route,RouteDto routeDto){
        route.setTimeStarting(routeDto.getTimeStarting());
        route.setTimeExpecting(routeDto.getTimeExpecting());
        route.setPrice(routeDto.getPrice());
        route.setDestination(routeDto.getDestination());
        route.setStartingPoint(routeDto.getStartingPoint());
        route.setCars((Set<Car>) carConversion.toCarEntity((CarDto) routeDto.getCarsDto()));
        return route;
    }
}
