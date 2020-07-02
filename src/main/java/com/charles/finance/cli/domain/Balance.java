// File: Balance.java
// Created: 2020/07/02
// Last Changed: 2020/07/02 02:28:41
// Author: <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>

// This code is copyright (c) ehealth4everyone

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

    /**
     * method returns amount.
     * @return amount
     */
    public long getAmount() {
        return amount;
    }
}
