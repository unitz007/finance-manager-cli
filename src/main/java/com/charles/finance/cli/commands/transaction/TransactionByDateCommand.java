package com.charles.finance.cli.commands.transaction;

import picocli.CommandLine;

@CommandLine.Command(name = "--by-date", description = "Lists transactions by specified date")
public class TransactionByDateCommand implements Runnable {

    @CommandLine.Option(names = "--date", required = true, description = "param")
    private String date;

    @Override
    public void run() {
        System.out.println("By date " + date);
    }
}
