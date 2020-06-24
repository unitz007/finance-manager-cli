package com.charles.finance.cli.domain;

import lombok.Data;

@Data
public class Transactions {

    private Long id;
    private String type;
    private Long amount;
    private String description;
    private String category;

}
