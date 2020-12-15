package com.kltn.booking.conversions;

import com.kltn.booking.dtos.basedtos.SessionDto;
import com.kltn.booking.entities.SessionR;
import org.springframework.stereotype.Component;

@Component
public class SessionConversion {

    private final RouteConversion routeConversion;


    public SessionConversion(RouteConversion routeConversion) {
        this.routeConversion = routeConversion;
    }

    public SessionR toSessionEntity(SessionDto sessionDto) {
        SessionR session=new SessionR();
        session.setDepartDate(sessionDto.getDepartDate());
        session.setRoute(routeConversion.toRouteEntity(sessionDto.getRouteDto()));
        return session;
    }
    public SessionDto toSessionDto(SessionR sessionR){
        SessionDto sessionDto=new SessionDto();
        if (sessionR.getId()!=null)
            sessionDto.setId(sessionR.getId());
        sessionDto.setDepartDate(sessionR.getDepartDate());
        sessionDto.setRouteDto(routeConversion.toRouteDto(sessionR.getRoute()));
        return sessionDto;
    }
    public SessionR toSessionEntity(SessionR sessionR,SessionDto sessionDto){
        sessionR.setDepartDate(sessionDto.getDepartDate());
        sessionR.setRoute(routeConversion.toRouteEntity(sessionDto.getRouteDto()));
        return sessionR;
    }
}
