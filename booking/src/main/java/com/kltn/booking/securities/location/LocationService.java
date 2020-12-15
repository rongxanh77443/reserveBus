package com.kltn.booking.securities.location;

import com.kltn.booking.dtos.basedtos.LocationDto;
import com.kltn.booking.entities.Location;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LocationService {
    
    Page<Location> getAllLocationsPaging(String search, int page, int size, String sort, String column);

    LocationDto createLocation(LocationDto dto);

    LocationDto updateLocation(Long id, LocationDto dto);

    LocationDto getLocation(Long id);

    String deleteLocation(Long id);

    List<LocationDto> getAllLocations();
}
