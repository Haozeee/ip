package tasks;

import duke.DukeDate;
import exceptions.DukeInvalidDateException;

/**
 * A class to abstract a deadline which is a type of task with a date
 * to be completed by.
 */
public class Deadline extends Task {

    /** The deadline that this task should be completed by. */
    private final DukeDate deadline;

    public Deadline(String taskName, DukeDate deadline) {
        super(taskName, Type.DEADLINE);
        this.deadline = deadline;
    }

    /**
     * Creates a new deadline task based on the input by a user.
     *
     * @param input An input in the form of a task name followed by the keyword "-by"
     *              then followed by the task deadline.
     * @return The newly created task deadline
     * @throws exceptions.DukeInvalidDateException Throws an exception when the user tries to create a deadline
     * task with a specified date but formats the date wrongly.
     */
    public static Deadline newDeadlineTask(String input) throws DukeInvalidDateException {
        String[] inputArr = input.split("-by|/by");
        String taskName = inputArr[0].trim();
        String completedBy = inputArr[1].trim();
        if (input.contains("-by")) {
            return new Deadline(taskName, DukeDate.of(completedBy, false));
        } else {
            return new Deadline(taskName, DukeDate.of(completedBy, true));
        }
    }

    @Override
    public String taskDescription() {
        return this.getTaskName() + " (by: " + this.deadline + ")";
    }

    @Override
    public String taskSaveString() {
        String isDone = this.isDone() ? "1" : "0";
        return "D | " + isDone + " | " + this.deadline.getDateType()
                + " | " + this.getTaskName() + " | " + this.deadline;
    }
}