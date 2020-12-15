package com.kltn.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Route  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String startingPoint;

    private String destination;

    private String timeStarting;

    private String timeExpecting;

    private Integer price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "route_cars",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<Car> cars= new HashSet<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private Collection<SessionR> sessionRs;
}
