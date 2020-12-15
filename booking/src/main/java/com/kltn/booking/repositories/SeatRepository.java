package com.kltn.booking.repositories;

import com.kltn.booking.entities.Seat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Query(value = "select u from Seat u where u.name like %?1% order by u.name asc")
    Page<Seat> getAllSeatsPaging(String search, Pageable pageable);

    @Query(value="CALL getAllSeatsWithChosenCar(:carId)",nativeQuery = true)
    Collection<Object[]> getAllSeatsWithChosenCar(@Param("carId") Long carId);


}
