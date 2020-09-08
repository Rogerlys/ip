package duke.parts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import duke.task.Task;

/**
 * A class to handle the response and output that is being shown to the user.
 */
public class Ui {
    static final String LINE = "    ____________________________________________________________";
    static final String INDENT = "    ";
    private Scanner sc = new Scanner(System.in);

    /**
     * Prints the welcome message
     */
    public void showWelcome() {
        System.out.println(LINE);
        System.out.println(INDENT + "Hello! What can I do for you?");
        System.out.println(LINE);
    }

    public void showLine() {
        System.out.println(LINE);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public String printNumTask(int numTask) {
        return String.format("%syou have %d tasks in the list.", INDENT, numTask);
    }

    /**
     * Shows the response after an item is deleted.
     * @param removed Task that have been removed.
     * @param numLeft Remaining number of tasks in the system
     * @return The appropriate response.
     */
    public String showDelete(Task removed, int numLeft) {
        String taskLeft = printNumTask(numLeft);
        String output = INDENT + "Tasked removed: " + "\n"
                                + INDENT + removed.getOutput() + "\n"
                                + taskLeft;
        System.out.println(output);
        return output;
    }

    /**
     * Prints the list of task in the system
     * @param storage Storage of the system.
     * @return The appropriate response.
     * @throws IOException
     */
    public String printList(Storage storage) throws IOException {
        ArrayList<Task> arrTask = storage.load();
        String output = printNumTask(arrTask.size()) + "\n";
        output += INDENT + "Here are the tasks in your list:\n";
        for (int i = 0; i < arrTask.size(); i++) {
            output += String.format("%s%d. %s", INDENT, i + 1, arrTask.get(i).getOutput());
            if (i < arrTask.size() - 1) {
                output += "\n";
            }
        }
        System.out.println(output);
        return output;
    }

    /**
     * Shows the response after an item is added.
     * @param task Task that is added.
     * @param type The type of task.
     * @param numTask Number of task in the system before adding this task.
     * @return The appropriate response.
     */
    public String printNew(Task task, String type, int numTask) {
        String output = String.format("%sAdding %s to the list:\n", INDENT, type)
                        + String.format("%s %s\n", INDENT, task.getOutput())
                                + printNumTask(numTask);
        System.out.println(output);
        return output;
    }

    /**
     * Shows the tasks that macthes the search criteria.
     * @param arr Arraylist of items that has been found.
     * @return The appropriate response.
     */
    public String printFind(ArrayList<Task> arr) {
        if (arr.isEmpty()) {
            System.out.println(INDENT + "There are no items");
            return INDENT + "There are no items";
        } else {
            String output = INDENT + "Here are the items that match the search request\n";
            for (int i = 0; i < arr.size(); i++) {
                output += String.format("%s%d) %s", INDENT, i + 1,
                        arr.get(i).getOutput()) + "\n";
            }
            System.out.println(output);
            return output;
        }
    }

    /**
     * Prints the closing message.
     * @return The closing message.
     */
    public String bye() {
        System.out.println(INDENT + "Bye. Hope to see you again soon");
        return INDENT + "Bye. Hope to see you again soon";
    }

    public String printSort() {
        return "";
    }
}
