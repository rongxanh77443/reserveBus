package com.kltn.booking.repositories;

import com.kltn.booking.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:03 PM
 * Filename  : UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.username like %?1% or u.email like %?1% or u.fullName like %?1% order by u.enable desc, u.fullName asc")
    Page<User> getAllUsersPaging(String search, Pageable pageable);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
    
    boolean existsByAddress(String address);

    boolean existsByPhoneNumber(String phoneNumber);
}
