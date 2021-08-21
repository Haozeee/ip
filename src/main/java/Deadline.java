
/**
 * A class to abstract a deadline which is a type of task with a date
 * to be completed by.
 */
public class Deadline extends Task {

    /** The deadline that this task should be completed by. */
    private final String deadline;

    public Deadline(String taskName, String deadline) {
        super(taskName, Type.DEADLINE);
        this.deadline = deadline;
    }

    /**
     * Creates a new deadline task based on the input by a user.
     *
     * @param input An input in the form of a task name followed by the keyword "-by"
     *              then followed by the task deadline.
     * @return The newly created task deadline
     */
    public static Deadline newDeadlineTask(String input) {
        String[] inputArr = input.split("-by");
        String taskName = inputArr[0].trim();
        String completedBy = inputArr[1].trim();
        return new Deadline(taskName, completedBy);
    }

    @Override
    public String taskDescription() {
        return this.getTaskName() + " (by: " + this.deadline + ")";
    }

    @Override
    public String taskSaveString() {
        String isDone = this.isDone() ? "1" : "0";
        return "D | " + isDone + " | " + this.getTaskName() + " | " + this.deadline;
    }
}
