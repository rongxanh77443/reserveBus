package com.kltn.booking.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paging {
    private String sort;

    private String first_page;

    private String next_page;

    private String previous_page;

    private String last_page;

    private int total_pages;

    private int from_row;

    private int to_row;

    private int total_rows;

    private List<Object> rows;
}
