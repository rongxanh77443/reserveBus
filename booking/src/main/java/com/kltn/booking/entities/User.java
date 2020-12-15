package com.kltn.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/1/2020
 * Time      : 12:58 PM
 * Filename  : User
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String fullName;

    private String dateOfBirth;

    private String gender;

    private String phoneNumber;

    private String address;



    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, updatable = false)})
    private List<Role> roles = new ArrayList<>();

    private boolean enable = true;
}
