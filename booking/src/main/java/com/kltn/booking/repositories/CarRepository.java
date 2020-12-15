package com.kltn.booking.repositories;

import com.kltn.booking.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query(value = "select u from Car u where u.name like %?1% order by u.name asc")
    Page<Car> getAllCarsPaging(String search, Pageable pageable);

    @Query(value = "CALL getAllInforCarChosen(:startingPoint,:Destination,:departDate)",nativeQuery = true)
    Collection<Object[]> getAllInfoCarChosen(@Param("startingPoint") String startingPoint,@Param("Destination") String Destination,@Param("departDate") String departDate);
}
