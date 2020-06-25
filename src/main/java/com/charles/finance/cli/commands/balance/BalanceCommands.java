package com.charles.finance.cli.commands.balance;

import com.charles.finance.cli.Config;
import com.charles.finance.cli.domain.Balance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;

import java.util.Objects;

@CommandLine.Command(name = "balance", description = "Displays balance")
public class BalanceCommands implements Runnable {

    private String url = Config.baseUrl() + "/balance";
    private RestTemplate restTemplate = Config.restTemplate();

    @Override
    public void run() {
         ResponseEntity<Balance> balance = restTemplate.getForEntity(url, Balance.class);
        System.out.println(Objects.requireNonNull(balance.getBody()).getAmount());
    }
}
