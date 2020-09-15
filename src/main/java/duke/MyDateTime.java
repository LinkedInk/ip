package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MyDateTime {
    /**
     * Parses date time and returns a LocalDateTime object
     * Used when parsing user date time input
     *
     * @param string date time in the format of " dd/MM/yyyy HHmm"
     * @return LocalDateTime object parsed from the input string
     * @throws DateTimeParseException
     */
    // change this to increase the formats accepted for date time
    public static LocalDateTime parse(String string) throws DateTimeParseException {
        try {
            return LocalDateTime.parse(string, DateTimeFormatter.ofPattern(" dd/MM/yyyy HHmm"));
        } catch (DateTimeParseException e) {
            throw e;
        }
    }

    /**
     * Parses date time and returns a LocalDateTime object
     * Used for loading off a text file
     *
     * @param string default format of date time of LocalDateTime class
     *               date time in the format of "yyyy-MM-dd" + "T" + "HH:mm", "T" being just a letter in the string
     * @return LocalDateTime object parsed from the input string
     * @throws DateTimeParseException
     */
    public static LocalDateTime load(String string) throws DateTimeParseException {
        try {
            return LocalDateTime.parse(string);
        } catch (DateTimeParseException e) {
            throw e;
        }
    }
}
