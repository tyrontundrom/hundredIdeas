package pl.tyrontundrom.handlers;

import pl.tyrontundrom.input.UserInputCommand;

public class HelpCommandHandler extends BaseCommandHandler {


    public static final String COMMAND_NAME = "help";

    @Override
    public void handle(UserInputCommand command) {
        System.out.println("help..");
        System.out.println("Allowed command: help, quit, category, question, answer");
        System.out.println("Command pattern: <command> <action> <param1> <param2>");
        System.out.println("Example: category add CategoryName");
    }


    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
