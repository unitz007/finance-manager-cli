package com.charles.finance.cli.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Balance {

    private Long id;
    private LocalDate date;
    private long amount;

}
