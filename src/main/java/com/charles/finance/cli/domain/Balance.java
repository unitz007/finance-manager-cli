package com.charles.finance.cli.domain;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
public class Balance {

    private Long id;
    private LocalDate date;
    private long amount;

    public long getAmount() {
        return amount;
    }
}
