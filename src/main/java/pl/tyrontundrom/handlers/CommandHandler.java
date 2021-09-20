package pl.tyrontundrom.handlers;

import pl.tyrontundrom.input.UserInputCommand;

public interface CommandHandler {
    void handle(UserInputCommand command);

    boolean supports(String name);
}
