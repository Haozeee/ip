package tasks;

import duke.DukeDate;

/**
 * A class that abstracts a task.
 */
public abstract class Task {

    // The type of task
    public enum Type {
        TODO,
        DEADLINE,
        EVENT
    }

    /** Whether the task had been completed or not */
    private boolean isDone = false;
    /** The name of a task as given by the user */
    private final String taskName;
    /** The type of the task */
    private final Type type;

    public Task(String taskName, Type type) {
        this.taskName = taskName;
        this.type = type;
    }

    /**
     * Returns a description of the task filled with its details.
     *
     * @return The description of the task.
     */
    public abstract String taskDescription();

    /**
     * Converts a task into a specified String format for saving into local storage.
     * The format to save the strings is {type of task} | {is done} | {type of date}|
     * {task name} | {time (if applicable)}.
     * The type of date is based on the static variables in the duke.DukeDate class. It is only applicable
     * for deadline and event tasks.
     *
     * @return The String format to save the task as.
     */
    public abstract String taskSaveString();

    /**
     * Marks a task as completed.
     */
    public void setAsFinished() {
        this.isDone = true;
    }

    /**
     * Returns the string representation of the type of task.
     *
     * @return The required string representation.
     */
    public String eventTypeToString() {
        if (this.type.equals(Type.TODO)) {
            return "[T]";
        } else if (this.type.equals(Type.EVENT)) {
            return "[E]";
        } else {
            return "[D]";
        }
    }

    /**
     * Returns a task from the String used to saved the task in local storage. When a task is saved to local
     * storage it is saved as a formatted string that stores the information of the task. This methods takes
     * that String and converts it back to the correct task.
     *
     * @param saveString The String that represents the saved task.
     * @return The task converted from saveString.
     */
    public static Task stringToTask(String saveString) {
        String[] strComponents = saveString.split("\\|");
        String typeOfTask = strComponents[0].strip();
        boolean isDone = strComponents[1].strip().equals("1");
        int dukeDateType = Integer.parseInt(strComponents[2].strip());
        String taskName = strComponents[3].strip();
        Task loadedTask;
        if (typeOfTask.equals("T")) {
            loadedTask = Todo.newTodoTask(taskName);
        } else if (typeOfTask.equals("D")) {
            loadedTask = new Deadline(taskName, DukeDate.GetDukeDateFromType(strComponents[4].strip(), dukeDateType));
        } else {
            loadedTask = new Event(taskName, DukeDate.GetDukeDateFromType(strComponents[4].strip(), dukeDateType));
        }
        loadedTask.isDone = isDone;
        return loadedTask;
    }

    /**
     * Returns a string representation of the task with its task name and its completion status.
     *
     * @return The string representation of the task.
     */
    @Override
    public String toString() {
        if (this.isDone) {
            return eventTypeToString() +  "[X] " + this.taskDescription();
        }
        return eventTypeToString() + "[] " + this.taskDescription();
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isDone() {
        return isDone;
    }
}