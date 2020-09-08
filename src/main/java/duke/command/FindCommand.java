package duke.command;

import java.io.IOException;
import java.util.ArrayList;

import duke.error.IncorrectFormat;
import duke.parts.Storage;
import duke.parts.TaskList;
import duke.parts.Ui;
import duke.task.Task;

public class FindCommand extends Command {

    private String input;

    public FindCommand(String input) {
        this.input = input;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws IncorrectFormat, IOException {
        ArrayList<Task> found = tasks.find(input);
        return ui.printFind(found);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
