import java.util.ArrayList;
import java.util.Scanner;

/**
 * A chat bot.
 */
public class Duke {

    /**
     * When run, opens a chat bot that greets the user and echos any user's input. If the input
     * is bye the chat bot is closed.
     * @param args Not used.
     */
    public static void main(String[] args) {
        startUp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = UserInputs.getUserInput(scanner);
            if (!UserInputs.evaluateUserInput(input)) {
                endChat();
                break;
            }
        }
    }

    private static void startUp() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello, I'm\n" + logo);
        System.out.println("\n What can I help you with? \n\n");
    }

    private static void endChat() {
        System.out.println("Bye!! Hope to see you again!!");
    }
}
