package com.kltn.booking.securities.car;

import com.kltn.booking.conversions.CarConversion;
import com.kltn.booking.dtos.basedtos.CarDto;
import com.kltn.booking.entities.Car;
import com.kltn.booking.repositories.CarRepository;
import com.kltn.booking.repositories.SeatRepository;
import com.kltn.booking.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{


    private final CarRepository carRepository;


    private final CarConversion carConversion;

    public CarServiceImpl(CarRepository carRepository, SeatRepository seatRepository1, CarConversion carConversion) {
        this.carRepository = carRepository;
        this.carConversion = carConversion;
    }
    
    @Override
    public Page<Car> getAllCarsPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        return carRepository.getAllCarsPaging(search, pageable);
    }

    @Override
    public CarDto createCar(CarDto dto) {
        Car car=carConversion.toCarEntity(dto);
        carRepository.save(car);
        return carConversion.toCarDto(car);
    }

    @Override
    public CarDto updateCar(Long id, CarDto dto) {
        Car car= carRepository.getOne(id);
        car=carConversion.toCarEntity(car,dto);
        carRepository.save(car);
        return carConversion.toCarDto(car);
    }

    @Override
    public CarDto getCar(Long id) {
        Car car=carRepository.getOne(id);
        return carConversion.toCarDto(car);
    }

    @Override
    public String deleteCar(Long id) {
        try {
            carRepository.delete(carRepository.getOne(id));
            return "OK";
        }
        catch (Exception e){
            System.out.println("Exception "+e);
            return "NO";
        }
    }

}
