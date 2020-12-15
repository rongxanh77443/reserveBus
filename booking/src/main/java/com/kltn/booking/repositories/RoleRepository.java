package com.kltn.booking.repositories;

import com.kltn.booking.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 2:04 PM
 * Filename  : RoleRepository
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByNameIgnoreCase(String name);
}
