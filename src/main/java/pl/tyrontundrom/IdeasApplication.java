package pl.tyrontundrom;

import pl.tyrontundrom.input.UserInputCommand;
import pl.tyrontundrom.input.UserInputManager;

public class IdeasApplication {
    public static void main(String[] args) {
        new IdeasApplication().start();
    }

    private void start() {
        System.out.println("Start, App...");


        boolean applicationLoop = true;

        UserInputManager userInputManager = new UserInputManager();

        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
