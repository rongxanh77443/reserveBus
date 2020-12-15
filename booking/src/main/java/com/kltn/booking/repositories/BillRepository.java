package com.kltn.booking.repositories;

import com.kltn.booking.dtos.basedtos.BillDto;
import com.kltn.booking.entities.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {

    @Query(value = "select u from Bill u where u.payment like %?1% order by u.status asc")
    Page<Bill> getAllBillsPaging(String search, Pageable pageable);

    Collection<Bill> findByCreatedBy(Long idWhomCreateBy);
}
