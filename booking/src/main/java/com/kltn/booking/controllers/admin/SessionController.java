package com.kltn.booking.controllers.admin;

import com.kltn.booking.dtos.basedtos.SessionDto;
import com.kltn.booking.entities.SessionR;
import com.kltn.booking.securities.session.SessionServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/rest/session")
@PreAuthorize("hasRole('ADMIN')")
public class SessionController {

    private final SessionServiceImpl sessionService;

    public SessionController(SessionServiceImpl sessionService) {
        this.sessionService = sessionService;
    }

    @ApiOperation(value = "Get all session phân trang cho admin")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paging")
    public ResponseEntity<Page<SessionDto>> getAllSessionsPaging(
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "page", required = false, defaultValue = "${paging.default.page}") int page,
            @RequestParam(name = "size", required = false, defaultValue = "${paging.default.size}") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "column", required = false, defaultValue = "departDate") String column) {
        return new ResponseEntity<>(sessionService.getAllSessionsPaging(search, page, size, sort, column), HttpStatus.OK);
    }

    @ApiOperation(value = "Create Session")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<SessionDto> createSession(@Valid @RequestBody SessionDto dto){
        return new ResponseEntity<>(sessionService.createSession(dto),HttpStatus.OK);
    }

    @ApiOperation(value = "Update Session")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<SessionDto> updateSession(@Valid @RequestBody SessionDto dto){
        return new ResponseEntity<>(sessionService.updateSession(dto.getId(), dto),HttpStatus.OK);
    }

    @ApiOperation(value = "change status Session")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSession(@PathVariable Long id){
        return new ResponseEntity<>(sessionService.deleteSession(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Get Session by id")
    @GetMapping("/{id}")
    public ResponseEntity<SessionDto> getSession(@PathVariable Long id){
        return new ResponseEntity<>(sessionService.getSession(id),HttpStatus.OK);
    }
}
