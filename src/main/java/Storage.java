import java.util.ArrayList;

public class Storage {

    private ArrayList<Task> storage = new ArrayList<>();

    public void addTask(Task task) {
        storage.add(task);
        Text.normalPrint("Got it. I've added this task:\n  " +
                task.toString() + "\n" +
                "Now you have " + size() + " tasks in the list.");
    }

    public int size() {
        return storage.size();
    }

    public void printOut() {
        String temp = "Here are the tasks in your list:";
        int counter = 1;
        for (Task item: storage) {
            temp += "\n";
            temp += counter + ". " + item.toString();
            counter++;
        }
        Text.normalPrint(temp);
    }

    public void markDone(int position) {
        try {

            if (storage.get(position - 1).markDone()) {
                Text.normalPrint("beri gude, finish that thing liao\n  " +
                        storage.get(position - 1).toString());
            } else {
                Text.normalPrint("Task alr finish liao\n  " +
                        storage.get(position - 1).toString());
            }

        } catch (IndexOutOfBoundsException e) {
            Text.printTaskNotFoundError();
        }
    }

    public void deleteTask(int position) {
        try {

            Task task = storage.get(position - 1);
            storage.remove(position - 1);
            Text.normalPrint("Noted. I've removed this task:\n  " +
                    task.toString() + "\n" +
                    "Now you have " + size() + " tasks in the list.");

        } catch (IndexOutOfBoundsException e) {
            Text.printTaskNotFoundError();
        }
    }
}
