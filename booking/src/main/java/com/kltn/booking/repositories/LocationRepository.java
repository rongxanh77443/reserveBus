package com.kltn.booking.repositories;

import com.kltn.booking.entities.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

    @Query(value = "select u from Location u where u.name like %?1% order by u.name asc")
    Page<Location> getAllLocationsPaging(String search, Pageable pageable);
}
