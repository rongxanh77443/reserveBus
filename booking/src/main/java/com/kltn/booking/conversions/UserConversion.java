package com.kltn.booking.conversions;

import com.kltn.booking.dtos.basedtos.UserDto;
import com.kltn.booking.entities.Role;
import com.kltn.booking.entities.User;
import com.kltn.booking.repositories.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConversion {

    private final RoleRepository roleRepository;

    public UserConversion(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public User toUserEntity(UserDto userDto){
        User user= new User();
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setFullName(userDto.getFullName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmail(userDto.getEmail());
        user.setEnable(userDto.isEnable());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        List<Role> roleList= new ArrayList<>();
        for (Long roleId: userDto.getRoleIds())
        {
            roleList.add(roleRepository.findById(roleId).get());
        }
        user.setRoles(roleList);
        return user;
    }

    public UserDto toUserDto(User user){
        UserDto userDto=new UserDto();
        if (user.getId()!=null)
        {
            userDto.setId(user.getId());
        }
        userDto.setAddress(user.getAddress());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setEmail(user.getEmail());
        userDto.setEnable(user.isEnable());
        userDto.setGender(user.getGender());
        userDto.setFullName(user.getFullName());
        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setUsername(user.getUsername());
        List<Long> roleIds= new ArrayList<>();
        for (Role role:user.getRoles()){
            roleIds.add(role.getId());
        }
        userDto.setRoleIds(roleIds);
        return userDto;
    }
    public User toUserEntity(User user,UserDto userDto)
    {
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setFullName(userDto.getFullName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmail(userDto.getEmail());
        user.setEnable(userDto.isEnable());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        List<Role> roleList= new ArrayList<>();
        for (Long roleId: userDto.getRoleIds())
        {
            roleList.add(roleRepository.findById(roleId).get());
        }
        user.setRoles(roleList);
        return user;
    }
}
