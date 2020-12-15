package com.kltn.booking.repositories;

import com.kltn.booking.entities.Car;
import com.kltn.booking.entities.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    @Query(value = "select u from Route u where u.startingPoint like %?1% and u.destination like %?1% order by u.destination asc")
    Page<Route> getAllRoutesPaging(String search, Pageable pageable);

}
