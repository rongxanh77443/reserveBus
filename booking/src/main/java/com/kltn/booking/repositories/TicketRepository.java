package com.kltn.booking.repositories;

import com.kltn.booking.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query(value = "select u from Ticket u where u.status like %?1% order by u.status asc")
    Page<Ticket> getAllTicketsPaging(String search, Pageable pageable);
}
