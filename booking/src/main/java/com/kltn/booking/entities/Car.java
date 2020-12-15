package com.kltn.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Collection<Seat> seats;

    @ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY)
    private Set<Route> routes;

    private String driverName;

    private String carNumber;
}
