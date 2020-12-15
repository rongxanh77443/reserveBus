package com.kltn.booking.conversions;

import com.kltn.booking.dtos.basedtos.CarDto;
import com.kltn.booking.entities.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConversion {

    public Car toCarEntity(CarDto carDto){
        Car car=new Car();
        car.setDriverName(carDto.getDriverName());
        car.setCarNumber(carDto.getCarNumber());
        car.setName(carDto.getName());
        return car;
    }
    public CarDto toCarDto(Car car){
        CarDto carDto=new CarDto();
        if (car.getId()!=null)
            carDto.setId(car.getId());
        carDto.setDriverName(car.getDriverName());
        carDto.setCarNumber(car.getCarNumber());
        carDto.setName(car.getName());
        return carDto;
    }

    public  Car toCarEntity(Car car, CarDto carDto){
        car.setDriverName(carDto.getDriverName());
        car.setCarNumber(carDto.getCarNumber());
        car.setName(carDto.getName());
        return car;
    }
}
