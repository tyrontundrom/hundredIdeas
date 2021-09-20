package pl.tyrontundrom.handlers;

import pl.tyrontundrom.input.UserInputCommand;

abstract class BaseCommandHandler implements CommandHandler{

    @Override
    public boolean supports(String name) {
        return getCommandName().equals(name);
    }

    protected abstract String getCommandName();
}
