package com.kltn.booking.controllers.admin;

import com.kltn.booking.dtos.basedtos.UserDto;
import com.kltn.booking.entities.User;
import com.kltn.booking.securities.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:56 PM
 * Filename  : UserController
 */
@RestController
@RequestMapping("/rest/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get all user phân trang cho admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paging")
    public ResponseEntity<Page<User>> getAllUsersPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "fullName") String column) {
        return new ResponseEntity<>(userService.getAllUsersPaging(search, page, size, sort, column), HttpStatus.OK);
    }

    @ApiOperation(value = "Create user")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto dto){
        return new ResponseEntity<>(userService.createUser(dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update user")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto dto){
        return new ResponseEntity<>(userService.updateUser(dto.getId(), dto),HttpStatus.OK);
    }

    @ApiOperation(value = "change status user")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> changStatus(@PathVariable Long id){
        return new ResponseEntity<>(userService.changeStatus(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Get user by id")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }
}
