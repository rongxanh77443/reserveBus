package com.kltn.booking.repositories;

import com.kltn.booking.entities.SessionR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<SessionR,Long> {

    @Query(value = "select u from SessionR u where u.departDate like %?1% order by u.departDate asc")
    Page<SessionR> getAllSessionsPaging(String search, Pageable pageable);
}
