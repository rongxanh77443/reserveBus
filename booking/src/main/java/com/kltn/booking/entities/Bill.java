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
public class Bill  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyerId")
    private InfoBuyer buyer;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private Collection<Ticket> tickets;

    private int status;

    private int totalPrice;

    private String payment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sessionId",referencedColumnName = "id")
    private SessionR session;
}
