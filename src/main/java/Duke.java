import java.util.Scanner;

/**
 * A chat bot that is capable of recording tasks.
 * It records 3 types of tasks:
 * Todos: Tasks without any date attached.
 * Deadlines: Tasks that need to be done before a specific date.
 * Events: Tasks that start at a specific time and ends at a specific time.
 */
public class Duke {

    /** Error messages */
    public static final String DEADLINE_FORMAT = "deadline {Deadline name} -by {Date to be completed by}.\n"
            + "Use \"/by\" to specify that the input date is a formatted date.";
    public static final String EVENT_FORMAT = "event {Event name} -at {Date of event}.\n"
            + "Use \"/at\" to specify that the input date is a formatted date.";
    public static final String TODO_FORMAT = "todo {todo name}";
    public static final String DATE_FORMAT = "dd/MM/yyyy or dd/MM/yyyy HHmm";

    /**
     * When run, opens a chat bot that greets the user and echos any user's input. If the input
     * is bye the chat bot is closed.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        startUp();
        Scanner scanner = new Scanner(System.in);
        UserInputReader userInputReader = new UserInputReader(scanner);
        while (true) {
            String input = userInputReader.getUserInput();
            if (!userInputReader.evaluateUserInput(input)) {
                endChat();
                break;
            }
        }
    }

    private static void startUp() {
        String logo = " ____        _\n"
                + "|  _ \\ _   _| | _____\n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo + "\n");
        System.out.println("Hello, I'm Duke");
        System.out.println("What can I help you with?\n");
    }

    private static void endChat() {
        System.out.println("Bye!! Hope to see you again!!");
    }
}
