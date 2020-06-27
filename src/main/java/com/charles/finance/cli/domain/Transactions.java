package com.charles.finance.cli.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Transactions {

    private Long id;
    private String type;
    private Long amount;
    private String description;
    private String category;
    private String date;

    public String getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Long getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
