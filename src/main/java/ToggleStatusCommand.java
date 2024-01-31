public class ToggleStatusCommand implements Command {
    private final int index;

    public ToggleStatusCommand(String input) {
        this.index = Integer.parseInt(input.split(" ")[1]);
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.getTask(index).toggleIsDone();
        System.out.println(toggleMessage(tasks.getTask(index)));
    }

    private String toggleMessage(Task task) {
        String message = "";

        message += task.isDone ? Messages.MARK_MESSAGE : Messages.UNMARK_MESSAGE;
        message += "   " + task;
        
        return message;
    }
}