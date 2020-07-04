// File: config.java
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
 * defines command for querying all transactions.
 * @author <a href=mailto:bhd.hdff@e4email.net>Dinneya Charles</a>
 * @see java.lang.Runnable
 * @version 1.0.0 2020/07/01 22:08:01
 */
@CommandLine.Command(name = "--all", description = "Lists all Transactions")
public class AllTransactionsCommand implements Runnable {

    /* defines url used for making request */
    private final String url = Config.baseUrl() + "/transactions";
    private final RestTemplate restTemplate = Config.restTemplate();

    @Override
    public void run() {
        Transactions[] transactions = restTemplate.getForObject(url, Transactions[].class);
        assert transactions != null;

     // print Table
        Config.transactionTable(transactions);
    }
}
