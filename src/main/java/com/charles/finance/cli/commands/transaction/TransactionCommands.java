// File: TransactionCommands.java
// Created: 2020/07/02
// Last Changed: 2020/07/02 02:28:41
// Author: <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>

// This code is copyright (c) ehealth4everyone

package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import picocli.CommandLine;

/**
 * Entry point for transaction command.
 * @author <a href=mailto:charles.dinneya@e4email.net>Dinneya Charles</a>
 * @version 1.0.0 2020/07/01 22:08:01s
 */
@CommandLine.Command(name = "transaction", subcommands = {
        TransactionByTypeCommand.class,
        TransactionByDateCommand.class,
        AllTransactionsCommand.class,
        TransactionAddCommand.class
}, description = "Command for querying transactions")
public class TransactionCommands implements Runnable {

    private String url = Config.baseUrl() + "/transactions";

    /**
     * method is invoked when transaction command is made.
     * displays help if sub-commands are not specified
     */
    @Override
    public void run() {
            CommandLine cmd = new CommandLine(new TransactionCommands());
            CommandLine.Help.ColorScheme colorScheme
                    = new CommandLine.Help.ColorScheme.Builder()
                        .commands(CommandLine.Help.Ansi.Style.bold,
                                CommandLine.Help.Ansi.Style.fg_green)
                        .build();
            cmd.usage(cmd.getOut(), colorScheme);

    }

}

