package com.charles.finance.cli.commands.transaction;

import com.charles.finance.cli.Config;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;

@CommandLine.Command(name = "transaction", subcommands = {
        TransactionByTypeCommand.class,
        TransactionByDateCommand.class,
        AllTransactionsCommand.class
}, description = "for querying transactions")
public class TransactionCommands implements Runnable {

//    @CommandLine.Parameters(index = "0")
//    private String transactions;

    private String url = Config.baseUrl() + "/transactions";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run() {
            CommandLine cmd = new CommandLine(new TransactionCommands());
            CommandLine.Help.ColorScheme colorScheme = new CommandLine.Help.ColorScheme.Builder()
                    .commands(CommandLine.Help.Ansi.Style.bold, CommandLine.Help.Ansi.Style.fg_green)
                    .build()
                    ;
            cmd.usage(cmd.getOut(), colorScheme);

    }

}

