package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import com.charles.finance.cli.domain.Transactions;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;

/**
 * defines command for querying all transactions
 * @author Dinneya Charles
 * @see java.lang.Runnable
 * @version 1.0
 */
@CommandLine.Command(name = "--all", description = "Lists all Transactions")
public class AllTransactionsCommand implements Runnable {

    private String url = Config.baseUrl() + "/transactions";
    private RestTemplate restTemplate = Config.restTemplate();

    @Override
    public void run() {
        Transactions[] transactions = restTemplate.getForObject(url, Transactions[].class);
        assert transactions != null;

     // print Table
        Config.transactionTable(transactions);
    }
}