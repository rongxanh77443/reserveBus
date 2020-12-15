package com.kltn.booking.repositories;

import com.kltn.booking.entities.InfoBuyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoBuyerRepository extends JpaRepository<InfoBuyer,Long> {
    @Query(value = "SELECT u from User u where u.fullName like %?1% order by u.fullName asc")
    Page<InfoBuyer> getAllInfoBuyersPaging(String search, Pageable pageable);
}
