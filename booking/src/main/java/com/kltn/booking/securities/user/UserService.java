package com.kltn.booking.securities.user;

import com.kltn.booking.dtos.basedtos.UserDto;
import com.kltn.booking.entities.User;
import org.springframework.data.domain.Page;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:05 PM
 * Filename  : UserService
 */
public interface UserService {

    Page<User> getAllUsersPaging(String search, int page, int size, String sort, String column);

    UserDto createUser(UserDto dto);

    UserDto updateUser(Long id, UserDto dto);

    UserDto getUser(Long id);

    UserDto changeStatus(Long id);
}
