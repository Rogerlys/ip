public class AddCommand extends Command{

    String input;

    AddCommand(String input) {
        this.input = input;
    }

    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) throws IncorrectFormat {
        int space = input.indexOf(" ");
        int slash = input.indexOf("/");
        int length = input.length();
        Task newTask;
        switch(input.substring(0, space)) {
        case "todo":
            newTask = new ToDo(input.substring(space, length));
            ui.printNew(newTask, "ToDo", tasks.numTask() + 1);
            break;
        case "deadline":
            String dateStringDeadline = input.substring(slash + 1, input.length());
            newTask = new Deadline(input.substring(space, slash), dateStringDeadline);
            ui.printNew(newTask, "Deadline", tasks.numTask() + 1);
            break;
        case "event":
            String dateStringEvent = input.substring(slash + 1, input.length());
            newTask = new Event(input.substring(space, slash), dateStringEvent);
            ui.printNew(newTask, "Event", tasks.numTask() + 1);
            break;
        default:
            throw new IncorrectFormat();
        }
        tasks.addTask(newTask, storage);
    }

    @Override
    boolean isExit() {
        return false;
    }
}