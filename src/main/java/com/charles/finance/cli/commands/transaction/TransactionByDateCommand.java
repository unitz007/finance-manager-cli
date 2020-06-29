package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import com.charles.finance.cli.domain.Transactions;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;

/**
 * Defines command to query transaction by date
 * @author Dinneya Charles
 * @version 1.0
 */
@CommandLine.Command(name = "--by-date", description = "Lists transactions by specified date")
public class TransactionByDateCommand implements Runnable {

    @CommandLine.Option(names = "--date", required = true, description = "param")
    private String date;

    private RestTemplate restTemplate = Config.restTemplate();

    /**
     * makes a get request to url using spring's RestTemplate
     */
    @Override
    public void run() {
        String url = Config.baseUrl() + "/transactions/date?date=" + date;
        Transactions[] transactions = restTemplate.getForObject(url, Transactions[].class);
        assert transactions != null;
        Config.transactionTable(transactions);
    }
}
