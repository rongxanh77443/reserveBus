package com.kltn.booking.securities.location;

import com.kltn.booking.conversions.LocationConversion;
import com.kltn.booking.dtos.basedtos.LocationDto;
import com.kltn.booking.entities.Location;
import com.kltn.booking.repositories.LocationRepository;
import com.kltn.booking.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    private final LocationRepository locationRepository;

    private final LocationConversion locationConversion;

    public LocationServiceImpl(LocationRepository locationRepository, LocationConversion locationConversion) {
        this.locationRepository = locationRepository;
        this.locationConversion = locationConversion;
    }


    @Override
    public Page<Location> getAllLocationsPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        return locationRepository.getAllLocationsPaging(search, pageable);
    }

    @Override
    public LocationDto createLocation(LocationDto dto) {
        Location location= locationConversion.toLocationEntity(dto);
        locationRepository.save(location);
        return locationConversion.toLocationDto(location);
    }

    @Override
    public LocationDto updateLocation(Long id, LocationDto dto) {
        Location location= locationRepository.getOne(id);
        location=locationConversion.toLocationEntity(location,dto);
        locationRepository.save(location);
        return locationConversion.toLocationDto(location);
    }

    @Override
    public LocationDto getLocation(Long id) {
        Location location= locationRepository.getOne(id);
        return locationConversion.toLocationDto(location);
    }

    @Override
    public String deleteLocation(Long id) {
        try {
            locationRepository.delete(locationRepository.getOne(id));
            return "OK";
        }
        catch (Exception e){
            System.out.println("Exception "+e);
            return "NO";
        }
    }

    @Override
    public List<LocationDto> getAllLocations() {
        List<LocationDto> locationDtoList=new ArrayList<>();
        for (Location location: locationRepository.findAll())
        {
            locationDtoList.add(locationConversion.toLocationDto(location));
        }
        return locationDtoList;
    }
}
