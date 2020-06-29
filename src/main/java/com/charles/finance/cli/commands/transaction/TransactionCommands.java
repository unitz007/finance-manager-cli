package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import picocli.CommandLine;

/**
 * Entry point for transaction command
 * @author Dinneya Charles
 * @version 1.0
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
     * method is invoked when transaction command is made
     * displays help if sub-commands are not specified
     */
    @Override
    public void run() {
            CommandLine cmd = new CommandLine(new TransactionCommands());
            CommandLine.Help.ColorScheme colorScheme
                    = new CommandLine.Help.ColorScheme.Builder()
                        .commands(CommandLine.Help.Ansi.Style.bold, CommandLine.Help.Ansi.Style.fg_green)
                        .build()
                    ;
            cmd.usage(cmd.getOut(), colorScheme);

    }

}

