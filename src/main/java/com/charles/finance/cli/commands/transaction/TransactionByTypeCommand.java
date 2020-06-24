package com.charles.finance.cli.commands.transaction;

import picocli.CommandLine;

@CommandLine.Command(name = "--by-type", description = "Lists transactions with specified type")
public class TransactionByTypeCommand implements Runnable {

    @CommandLine.Option(names = "--type", required = true)
    private String type;

    @Override
    public void run() {
        System.out.println("By Type " + type);
    }
}
