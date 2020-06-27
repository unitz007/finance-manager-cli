package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import picocli.CommandLine;

@CommandLine.Command(name = "transaction", subcommands = {
        TransactionByTypeCommand.class,
        TransactionByDateCommand.class,
        AllTransactionsCommand.class
}, description = "Command for querying transactions")
public class TransactionCommands implements Runnable {

    private String url = Config.baseUrl() + "/transactions";

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

