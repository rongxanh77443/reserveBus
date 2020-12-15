package com.kltn.booking.securities.car;


import com.kltn.booking.dtos.basedtos.CarDto;
import com.kltn.booking.entities.Car;
import org.springframework.data.domain.Page;

public interface CarService {
    Page<Car> getAllCarsPaging(String search, int page, int size, String sort, String column);

    CarDto createCar(CarDto dto);

    CarDto updateCar(Long id, CarDto dto);

    CarDto getCar(Long id);

    String deleteCar(Long id);
}
