package pl.tyrontundrom.handlers;

import pl.tyrontundrom.input.UserInputCommand;

public class HelpCommandHandler extends BaseCommandHandler {


    public static final String COMMAND_NAME = "help";

    @Override
    public void handle(UserInputCommand command) {
        System.out.println("help..");
    }


    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
