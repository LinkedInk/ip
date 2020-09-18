package duke.tasks;

import duke.text.TextStore;

public abstract class Task {

    protected String description;
    protected boolean done = false;

    Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return done ? TextStore.doneText + description : TextStore.notDoneText + description;
    }

    public abstract String saveString();

    public abstract boolean equals(Task task);

    public boolean markDone() {
        if (done) {
            return false;
        } else {
            done = true;
            return true;
        }
    }
}
