package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import com.charles.finance.cli.domain.Transactions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;

import java.time.LocalDate;

/**
 * Defines command that adds a new transaction
 * @author Dinneya Charles
 * @version 1.0
 */
@CommandLine.Command(name = "--add", description = "Creates a new Transaction")
public class TransactionAddCommand implements Runnable {

        @CommandLine.Option(names = "--type", required = true, description = "type of transaction, either debit or credit") private String type;
        @CommandLine.Option(names = "--amount", required = true, description = "amount of transaction") private Long amount;
        @CommandLine.Option(names = "--description", description = "helpful description of the transaction") private String description;
        @CommandLine.Option(names = "--category", description = "category of the transaction") private String category;

        private String url = Config.baseUrl() + "/transactions";
        private RestTemplate restTemplate = Config.restTemplate();


    @Override
    public void run() {
        Transactions transactions = new Transactions();
        transactions.setAmount(amount);
        transactions.setCategory(category);
        transactions.setDescription(description);
        transactions.setType(type);
         transactions.setDate(LocalDate.now().toString());

        ResponseEntity<Transactions> responseEntity = restTemplate.postForEntity(url, transactions, Transactions.class);
        System.out.println("Success: Transaction created");
    }
}
