// File: TransactionByTypeCommand.java
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
 * Defines action to be taken when --by-type command is made.
 * @author <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>
 * @version 1.0.0 2020/07/01 22:08:01s
 */
@CommandLine.Command(name = "--by-type", description = "Lists transactions with specified type")
public class TransactionByTypeCommand implements Runnable {

    @CommandLine.Option(names = "--type", required = true)
    private String type;

    /**
     * method is invoked when --by-type is made.
     * method makes HTTP get request and displays output
     */
    @Override
    public void run() {
        String url = Config.baseUrl() + "/transactions/type?type=" + type;
        RestTemplate restTemplate = Config.restTemplate();
        Transactions[] transactions = restTemplate.getForObject(url, Transactions[].class);
        assert transactions != null;
        Config.transactionTable(transactions);
    }
}
