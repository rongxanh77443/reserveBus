package com.kltn.booking.controllers;

import com.kltn.booking.dtos.LoginDto;
import com.kltn.booking.dtos.TokenDetails;
import com.kltn.booking.exceptions.InvalidException;
import com.kltn.booking.exceptions.UserNotFoundAuthenticationException;
import com.kltn.booking.services.CustomUserDetailsService;
import com.kltn.booking.services.GoogleUserDetailsService;
import com.kltn.booking.services.JwtTokenUtils;
import com.kltn.booking.services.JwtUserDetails;
import com.kltn.booking.services.provider.UserAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 1:18 PM
 * Filename  : AuthenticationController
 */
@RestController
@RequestMapping("/rest/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private GoogleUserDetailsService googleUserDetailsService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Value("${google.verifyUrl}")
    private String googleVerifyUrl;

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/form")
    public ResponseEntity<TokenDetails> formLogin(@Valid @RequestBody LoginDto dto){
        UserAuthenticationToken authenticationToken = new UserAuthenticationToken(
                dto.getUsername(),
                dto.getPassword(),
                true
        );
        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (UserNotFoundAuthenticationException | BadCredentialsException ex) {
            throw new InvalidException(ex.getMessage());
        }
        final JwtUserDetails userDetails = customUserDetailsService.loadUserByUsername(dto.getUsername());
        final TokenDetails result = jwtTokenUtils.getTokenDetails(userDetails);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/google")
    public ResponseEntity<TokenDetails> googleLogin(@RequestHeader(name = "GoogleToken") String googleToken) {

        String urlRequest = googleVerifyUrl + googleToken;
        String email;
        try {
            ResponseEntity<HashMap> responseEntity = restTemplate.exchange(urlRequest, HttpMethod.GET, null, HashMap.class);
            HashMap<String, String> map = responseEntity.getBody();
            email = map.get("email");
        } catch (Exception ex) {
            throw new InvalidException("Token không hợp lệ");
        }
        UserAuthenticationToken authenticationToken = new UserAuthenticationToken(
                email,
                null,
                false
        );
        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (UserNotFoundAuthenticationException | BadCredentialsException ex) {
            throw new InvalidException(ex.getMessage());
        }
        final JwtUserDetails userDetails = googleUserDetailsService.loadUserByUsername(email);
        final TokenDetails result = jwtTokenUtils.getTokenDetails(userDetails);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/hello")
    public ResponseEntity<String> sayHello(Principal principal) {
        return new ResponseEntity<>(String.format("Authenticated: %s ", principal.getName()), HttpStatus.OK);
    }
}
