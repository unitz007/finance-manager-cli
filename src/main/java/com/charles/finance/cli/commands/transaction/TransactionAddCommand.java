// File: TransactionAddCommand.java
// Created: 2020/07/02
// Last Changed: 2020/07/02 02:28:41
// Author: <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>

// This code is copyright (c) ehealth4everyone

package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import com.charles.finance.cli.domain.Transactions;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;

import java.time.LocalDate;

/**
 * Defines command that adds a new transaction.
 * @author <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>
 * @version 1.0.0 2020/07/01 22:08:01
 */
@CommandLine.Command(name = "--add", description = "Creates a new Transaction")
public class TransactionAddCommand implements Runnable {

        @CommandLine.Option(names = "--type", required = true,
                description = "type of transaction, either debit or credit")
        private String type;
        @CommandLine.Option(names = "--amount", required = true,
                description = "amount of transaction")
        private Long amount;
        @CommandLine.Option(names = "--description",
                description = "helpful description of the transaction")
        private String description;
        @CommandLine.Option(names = "--category",
                description = "category of the transaction")
        private String category;

        private final String url = Config.baseUrl() + "/transactions";
        private final RestTemplate restTemplate = Config.restTemplate();


    @Override
    public void run() {
        Transactions transactions = new Transactions();
        transactions.setAmount(amount);
        transactions.setCategory(category);
        transactions.setDescription(description);
        transactions.setType(type);
         transactions.setDate(LocalDate.now().toString());

        restTemplate.postForEntity(url, transactions, Transactions.class);
        System.out.println("Success: Transaction created");
    }
}
