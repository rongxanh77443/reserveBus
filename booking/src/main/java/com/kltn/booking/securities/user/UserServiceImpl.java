package com.kltn.booking.securities.user;

import com.kltn.booking.conversions.UserConversion;
import com.kltn.booking.dtos.basedtos.UserDto;
import com.kltn.booking.entities.Role;
import com.kltn.booking.entities.User;
import com.kltn.booking.exceptions.DuplicateException;
import com.kltn.booking.exceptions.InvalidException;
import com.kltn.booking.exceptions.NotFoundException;
import com.kltn.booking.repositories.RoleRepository;
import com.kltn.booking.repositories.UserRepository;
import com.kltn.booking.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:05 PM
 * Filename  : UserServiceImpl
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserConversion userConversion;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserConversion userConversion) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userConversion = userConversion;
    }

    @Override
    public Page<User> getAllUsersPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        return userRepository.getAllUsersPaging(search, pageable);
    }

    @Override
    public UserDto createUser(UserDto dto) {
        if(StringUtils.isEmpty(dto.getUsername())){
            throw new InvalidException("Tên tài khoản không được bỏ trống");
        }
        if(StringUtils.isEmpty(dto.getPassword())){
            throw new InvalidException("Mật khẩu không được bỏ trống");
        }
        if(StringUtils.isEmpty(dto.getEmail())){
            throw new InvalidException("Email không được bỏ trống");
        }
        if(StringUtils.isEmpty(dto.getFullName())){
            throw new InvalidException("Họ tên không được bỏ trống");
        }
        if(userRepository.existsByUsername(dto.getUsername())){
            throw new DuplicateException(String.format("Tài khoản có username %s đã tồn tại",dto.getUsername()));
        }
        if(userRepository.existsByUsername(dto.getEmail())){
            throw new DuplicateException(String.format("Tài khoản có email %s đã tồn tại",dto.getEmail()));
        }
        User user = new User();
        user.setUsername(dto.getUsername().toLowerCase());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail().toLowerCase());
        user.setFullName(dto.getFullName());
        user.setEnable(true);
        userRepository.save(user);
        List<Role> roles = new ArrayList<>();
        dto.getRoleIds().forEach(roleId->{
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new NotFoundException(String.format("Role có id %s không tồn tại", roleId)));
            roles.add(role);
        });
        user.setRoles(roles);
        userRepository.save(user);
        return userConversion.toUserDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        if(StringUtils.isEmpty(dto.getPassword())){
            throw new InvalidException("Mật khẩu không được bỏ trống");
        }
        if(StringUtils.isEmpty(dto.getFullName())){
            throw new InvalidException("Họ tên không được bỏ trống");
        }
        User user = userRepository.findById(id).get();
        user=userConversion.toUserEntity(user,dto);
        userRepository.save(user);
        return userConversion.toUserDto(user);
    }

    @Override
    public UserDto getUser(Long id) {
        return userConversion.toUserDto(userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Tài khoản có id %s không tồn tại", id))));
    }

    @Override
    public UserDto changeStatus(Long id) {
        User user = userRepository.findById(id).get();
        user.setEnable(!user.isEnable());
        userRepository.save(user);
        return userConversion.toUserDto(user);
    }
}
