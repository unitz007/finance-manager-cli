// File: FinanceCliApplication.java
// Created: 2020/07/02
// Last Changed: 2020/07/02 02:28:41
// Author: <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>

// This code is copyright (c) ehealth4everyone

package com.charles.finance.cli;

import com.charles.finance.cli.commands.balance.BalanceCommands;
import com.charles.finance.cli.commands.transaction.TransactionCommands;
import picocli.CommandLine;

@CommandLine.Command(subcommands = {TransactionCommands.class,
        BalanceCommands.class},
        description = "CLI for consuming Finance Manager Webservice",
        name = "finance-cli")
public class FinanceCliApplication implements Runnable {

    private static final CommandLine CMD = new CommandLine(new FinanceCliApplication());

    /**
     *
     * @param args   command line arguments
     */
    public static void main(String[] args) {
        CMD.execute(args);
    }

    @Override
    public void run() {
       // cmd.setCommandName("finance-cli");
        CommandLine.Help.ColorScheme colorScheme = new CommandLine.Help.ColorScheme.Builder()
                .commands(CommandLine.Help.Ansi.Style.bold, CommandLine.Help.Ansi.Style.fg_green)
                .build();
        CMD.usage(CMD.getOut(), colorScheme);

    }
}
