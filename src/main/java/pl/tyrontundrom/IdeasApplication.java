package pl.tyrontundrom;

import pl.tyrontundrom.handlers.*;
import pl.tyrontundrom.input.UserInputCommand;
import pl.tyrontundrom.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IdeasApplication {
    private static Logger LOG = Logger.getLogger(IdeasApplication.class.getName());

    public static void main(String[] args) {
        new IdeasApplication().start();
    }

    private void start() {
       LOG.info("Start, App...");


        boolean applicationLoop = true;

        UserInputManager userInputManager = new UserInputManager();

        List<CommandHandler> handlerList = new ArrayList<>();
        handlerList.add(new HelpCommandHandler());
        handlerList.add(new QuitCommandHandler());
        handlerList.add(new CategoryCommandHandler());
        handlerList.add(new QuestionCommandHandler());
        handlerList.add(new AnswerCommandHandler());


        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                LOG.info(userInputCommand.toString());

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
                LOG.info("Quit...");
                applicationLoop = false;
            } catch (IllegalArgumentException e) {
                LOG.log(Level.WARNING, "validation exception " + e.getMessage());
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "unknown error", e);
            }

        }
    }
}
