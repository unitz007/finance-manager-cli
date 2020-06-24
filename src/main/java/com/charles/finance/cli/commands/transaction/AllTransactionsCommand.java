package com.charles.finance.cli.commands.transaction;

import picocli.CommandLine;

@CommandLine.Command(name = "--all", description = "Lists all Transactions")
public class AllTransactionsCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("All Transactions");
    }
}
