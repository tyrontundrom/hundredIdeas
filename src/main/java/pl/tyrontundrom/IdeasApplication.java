package pl.tyrontundrom;

import pl.tyrontundrom.handlers.CategoryCommandHandler;
import pl.tyrontundrom.handlers.CommandHandler;
import pl.tyrontundrom.handlers.HelpCommandHandler;
import pl.tyrontundrom.handlers.QuitCommandHandler;
import pl.tyrontundrom.input.UserInputCommand;
import pl.tyrontundrom.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IdeasApplication {
    public static void main(String[] args) {
        new IdeasApplication().start();
    }

    private void start() {
        System.out.println("Start, App...");


        boolean applicationLoop = true;

        UserInputManager userInputManager = new UserInputManager();

        List<CommandHandler> handlerList = new ArrayList<>();
        handlerList.add(new HelpCommandHandler());
        handlerList.add(new QuitCommandHandler());
        handlerList.add(new CategoryCommandHandler());


        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);

                Optional<CommandHandler> currentHandler = Optional.empty();
                for (CommandHandler handler : handlerList) {
                    if (handler.supports(userInputCommand.getCommand())) {
                        currentHandler = Optional.of(handler);
                        break;
                    }
                }
                currentHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + userInputCommand.getCommand()))
                        .handle(userInputCommand);

            } catch (QuiteIdeasApplicationException e) {
                System.out.println("Quit...");
                applicationLoop = false;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
