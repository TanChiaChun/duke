package tic2002.task;

public class Todo extends Task {
    //Constructor
    public Todo(String taskDescription) {
        super(taskDescription);
        typeIdt = CHAR_TODO;
    }
}