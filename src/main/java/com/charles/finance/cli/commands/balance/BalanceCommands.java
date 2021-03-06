// File: BalanceCommands.java
// Created: 2020/07/02
// Last Changed: 2020/07/02 02:28:41
// Author: <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>

// This code is copyright (c) ehealth4everyone

package com.charles.finance.cli.commands.balance;

import com.charles.finance.cli.Config;
import com.charles.finance.cli.domain.Balance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;

import java.util.Objects;

@CommandLine.Command(name = "balance", description = "Displays balance")
public class BalanceCommands implements Runnable {

    private final String url = Config.baseUrl() + "/balance";
    private final RestTemplate restTemplate = Config.restTemplate();

    @Override
    public void run() {
        ResponseEntity<Balance> balance = restTemplate.getForEntity(url, Balance.class);
        System.out.println("Balance: " + Objects.requireNonNull(balance.getBody()).getAmount());
    }
}
