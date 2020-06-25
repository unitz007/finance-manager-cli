package com.charles.finance.cli;

import com.charles.finance.cli.commands.balance.BalanceCommands;
import com.charles.finance.cli.commands.transaction.TransactionCommands;
import picocli.CommandLine;

@CommandLine.Command(subcommands = {
        TransactionCommands.class,
        BalanceCommands.class
}, description = "CLI for consuming Finance Manager Webservice", name = "finance-cli")
public class FinanceCliApplication implements Runnable {

    private static CommandLine cmd = new CommandLine(new FinanceCliApplication());

    public static void main(String[] args) {
        cmd.execute(args);
    }

    @Override
    public void run() {
       // cmd.setCommandName("finance-cli");
        CommandLine.Help.ColorScheme colorScheme = new CommandLine.Help.ColorScheme.Builder()
                .commands(CommandLine.Help.Ansi.Style.bold, CommandLine.Help.Ansi.Style.fg_green)
                .build()
                ;
        cmd.usage(cmd.getOut(), colorScheme);

    }
}
