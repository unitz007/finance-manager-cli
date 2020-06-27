package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import com.charles.finance.cli.domain.Transactions;
import dnl.utils.text.table.TextTable;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;

@CommandLine.Command(name = "--all", description = "Lists all Transactions")
public class AllTransactionsCommand implements Runnable {

    private String url = Config.baseUrl() + "/transactions";
    private RestTemplate restTemplate = Config.restTemplate();

    @Override
    public void run() {
        Transactions[] transactions = restTemplate.getForObject(url, Transactions[].class);
        assert transactions != null;

        String[] columns = {
                "Date", "Category", "Type", "description", "Amount [#]"
        };

        int col = columns.length;
        int row = transactions.length;

        Object[][] data = new Object[row][col];

        for (int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                Transactions t = transactions[i];
                data[i][0] = t.getDate();
                data[i][1] = t.getCategory();
                data[i][2] = t.getType();
                data[i][3] = t.getDescription();
                data[i][4] = t.getAmount();
            }
        }


        TextTable table = new TextTable(columns, data);
        table.setAddRowNumbering(true);
        table.printTable();

    }
}