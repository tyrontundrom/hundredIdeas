package pl.tyrontundrom.handlers;

import pl.tyrontundrom.QuiteIdeasApplicationException;
import pl.tyrontundrom.input.UserInputCommand;

public class QuitCommandHandler extends BaseCommandHandler {

    public static final String COMMAND_NAME = "quit";

    @Override
    public void handle(UserInputCommand command) {
        throw new QuiteIdeasApplicationException();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
