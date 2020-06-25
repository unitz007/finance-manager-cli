package com.charles.finance.cli.commands.balance;

import picocli.CommandLine;

@CommandLine.Command(name = "balance", description = "Displays balance")
public class BalanceCommands implements Runnable {


    @Override
    public void run() {
        System.out.println("Balance");
    }
}
