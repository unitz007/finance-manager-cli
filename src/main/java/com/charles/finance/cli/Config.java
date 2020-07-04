// File: Config.java
// Created: 2020/07/02
// Last Changed: 2020/07/02 02:28:41
// Author: <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>

// This code is copyright (c) ehealth4everyone

package com.charles.finance.cli;

import com.charles.finance.cli.domain.Transactions;
import dnl.utils.text.table.TextTable;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * carries global settings and configurations.
 * @author <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>.
 * @version 1.0.0 2020/07/01 22:08:01
 */
public class Config {

    /**
     * sets the base url.
     * @return String
     */
    @SuppressWarnings("SameReturnValue")
    public static String baseUrl() {
        return "https://charles-finance.herokuapp.com/api";
    }

    /**
     * defines rest templates.
     * sets the properties for rest template.
     * @return RestTemplate
     */
    public static RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        converterList.add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
    }

    /**
     * constructs and displays table for transactions when transactions is not empty.
     * @param transactions transactions to display
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public static void transactionTable(final Transactions[] transactions) {

        String[] columns = {
                "Date", "Category", "Type", "Description", "Amount [#]"
        };

        int col = columns.length;
        int row = transactions.length;
        int amountTotal = 0;

        // computes the total amount
        for (Transactions t: transactions) {
            amountTotal += t.getAmount();
        }

        Object[][] data = new Object[row][col];

        for (int i = 0; i < data.length; i++) {
            Transactions t = transactions[i];
            data[i][0] = t.getDate();
            data[i][1] = t.getCategory();
            data[i][2] = t.getType();
            data[i][3] = t.getDescription();
            data[i][4] = t.getAmount();
        }

        // checks if transaction is empty or not
        if (transactions.length == 0) {
            System.out.println("No transaction(s)");
        } else {
            // creates and displays table containing transactions
            TextTable table = new TextTable(columns, data);
            table.setAddRowNumbering(true);
            table.printTable();
            System.out.println();
            System.out.println("    Total Amount: " + amountTotal);
        }

    }
}
