// File: TransactionByDateCommand.java
// Created: 2020/07/02
// Last Changed: 2020/07/02 02:28:41
// Author: <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>

// This code is copyright (c) ehealth4everyone


package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import com.charles.finance.cli.domain.Transactions;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;

/**
 * Defines command to query transaction by date.
 * @author <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>
 * @version 1.0.0 2020/07/01 22:08:01
 */
@CommandLine.Command(name = "--by-date", description = "Lists transactions by specified date")
public class TransactionByDateCommand implements Runnable {

    @CommandLine.Option(names = "--date", required = true, description = "param")
    private String date;

    private final RestTemplate restTemplate = Config.restTemplate();

    /**
     * makes a HTTP get request based on specified date and displays output of request.
     */
    public void run() {
        String url = Config.baseUrl() + "/transactions/date?date=" + date;
        Transactions[] transactions = restTemplate.getForObject(url, Transactions[].class);
        assert transactions != null;
        Config.transactionTable(transactions);
    }
}
