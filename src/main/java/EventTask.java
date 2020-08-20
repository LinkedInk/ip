public class EventTask extends Task {

    private static String display = "[E]";
    private final String date;

    EventTask(String name, String date) {
        super(name);
        this.date = date;
    }

    @Override
    public String toString() {
        return display + super.toString() + " (at: " + date + ")";
    }
}
