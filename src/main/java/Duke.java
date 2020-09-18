import java.io.*;
import java.nio.file.Path;
import java.time.format.DateTimeParseException;

public class Duke {
    public static void main(String[] args) throws IOException {
        try {
            String home = System.getProperty("user.home");
            java.nio.file.Path path = java.nio.file.Paths.get(home, "Documents", "ipSave.txt");
            boolean directoryExists = java.nio.file.Files.exists(path);

            if (directoryExists) {
                Storage storage = readToStorage(path);
                run(storage);
            } else {
                run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void run() {
        MainLogic logic = new MainLogic();
        logic.main();
    }

    private static void run(Storage storage) {
        MainLogic logic = new MainLogic(storage);
        logic.main();
    }

    private static Storage readToStorage(Path path) throws IOException {
        Storage storage = new Storage();
        try {
            FileReader fr = new FileReader(path.toFile());
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null) {
                String info[] = str.split("/break/", 4);
                storage.loadInTask(infoToTask(info));
            }
        } catch (IOException e) {
            throw e;
        }
        return storage;
    }

    private static Task infoToTask(String info[]) {
        Task task;
        switch (info[0]) {
            case "T":
                task = new TodoTask(info[2]);
                break;
            case "D":
                try {
                    task = new DeadLineTask(info[2], DateTime.load(info[3]));
                } catch (DateTimeParseException e) {
                    throw new IllegalStateException("Unexpected time format: " + info[3]);
                }
                break;
            case "E":
                try {
                    task = new EventTask(info[2], DateTime.load(info[3]));
                } catch (DateTimeParseException e) {
                    throw new IllegalStateException("Unexpected time format: " + info[3]);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected type: " + info[0]);
        }

        if (info[1] == "true") {
            task.markDone();
        }

        return task;
    }
}
