package com.kltn.booking.conversions;

import com.kltn.booking.dtos.basedtos.LocationDto;
import com.kltn.booking.entities.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationConversion {

    public Location toLocationEntity(LocationDto locationDto){
        Location location=new Location();
        location.setName(locationDto.getName());
        return location;
    }
    public LocationDto toLocationDto(Location location){
        LocationDto locationDto=new LocationDto();
        if (location.getId()!=null)
            locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        return locationDto;
    }
    public Location toLocationEntity(Location location,LocationDto locationDto){
        location.setName(locationDto.getName());
        return location;
    }
}
