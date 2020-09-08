package duke.command;

import java.io.IOException;

import duke.error.DeadlineDateParseException;
import duke.error.EventDateParseException;
import duke.error.IncorrectFormat;
import duke.parts.Storage;
import duke.parts.TaskList;
import duke.parts.Ui;


public abstract class Command {

    public abstract String execute(TaskList tasks, Ui ui, Storage storage)
            throws IncorrectFormat, IOException, EventDateParseException, DeadlineDateParseException;

    public abstract boolean isExit();
}
