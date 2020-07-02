// File: Transactions.java
// Created: 2020/07/02
// Last Changed: 2020/07/02 02:28:41
// Author: <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>

// This code is copyright (c) ehealth4everyone

package com.charles.finance.cli.domain;

import lombok.Data;

@Data
public class Transactions {

    private String type;
    private Long amount;
    private String description;
    private String category;
    private String date;
}
