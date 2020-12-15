package com.kltn.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InfoBuyer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String email;

    private String numberPhone;

    private String address;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private Collection<Bill> bill;

}
