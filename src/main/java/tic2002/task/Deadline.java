package tic2002.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    //Declare constant variables
    protected final String STRING_BY = "by";

    //Declare variables
    protected String deadlineByString;
    protected LocalDateTime deadlineDateTime;

    //Constructor
    public Deadline(String taskDescription, String taskTime) {
        super(taskDescription);
        deadlineByString = taskTime;
        typeIdt = CHAR_DEADLINE;
    }

    public Deadline(String taskDescription, LocalDateTime taskDateTime) {
        super(taskDescription);
        deadlineDateTime = taskDateTime;
        typeIdt = CHAR_DEADLINE;
        isDateTimeFormat = true;
    }

    //Getter
    public String printToFile() {
        String tempString = super.printToFile() + CHAR_SEPARATOR_WRITE;

        if (isDateTimeFormat) {
            tempString += DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).format(deadlineDateTime);
        } else {
            tempString += deadlineByString;
        }

        return tempString;
    }

    @Override
    public String toString() {
        String tempString = "[" + typeIdt + "][" + getStatusIcon() + "] " + taskDescription + " (" + STRING_BY + ": ";

        if (isDateTimeFormat) {
            tempString += DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_OUTPUT).format(deadlineDateTime);
        } else {
            tempString += deadlineByString;
        }

        tempString += ")";

        return tempString;
    }
}