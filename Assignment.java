import java.time.LocalDateTime;

public class Assignment {
    private String name;
    private LocalDateTime dueDate;
    private int hoursToComplete;

    public Assignment(String name, LocalDateTime dueDate, int hoursToComplete) {
        this.name = name;
        this.dueDate = dueDate;
        this.hoursToComplete = hoursToComplete;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public int getHoursToComplete() {
        return hoursToComplete;
    }

    public void setHoursToComplete(int hoursToComplete) {
        this.hoursToComplete = hoursToComplete;
    }
}