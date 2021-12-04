import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ScheduleGenerator {
    private String name;
    private boolean notifications;
    /***
     * Checks if the due date and time is after the current date and time.
     *
     * @param assignment
     * @return
     */
    public static boolean checkDueDate(Assignment assignment) {
        return assignment.getDueDate().isAfter(LocalDateTime.now());
    }

    /***
     * Checks if the time to complete is greater than zero.
     *
     * @param assignment
     * @return
     */
    public static boolean checkCompletionTime(Assignment assignment) {
        return assignment.getHoursToComplete() > 0;
    }

    /***
     * Checks if there is enough time between now and the due date to complete the assignment.
     *
     * @param assignment
     * @return
     */
    public static boolean checkIfPossible(Assignment assignment) {
        long timeToDueDate = ChronoUnit.HOURS.between(LocalDateTime.now(), assignment.getDueDate());
        return timeToDueDate >= assignment.getHoursToComplete();
    }

    public static String addAssignment(Assignment assignment) {
        if (!checkDueDate(assignment)) {
            return "Due date must be after current date.";
        }
        if (!checkCompletionTime(assignment)) {
            return "Time to complete must be greater than zero.";
        }
        if (!checkIfPossible(assignment)) {
            return "There is not enough time between now and the due date to schedule this assignment.";
        }

        return "Valid Schedule!";
    }
    
    /***
     * Sets the name for the schedule
     */
    public void setScheduleName(String name){
        this.name = name;
    }
    
    /***
     * Returns name set for the schedule
     */
    public String getScheduleName(){
        return name;
    }
    
    /***
     * Sets whether or not notifications are on
     */
    public void setNotifications(boolean notifications){
        this.notifications = notifications;
    }
    
    /***
     * Returns notification setting
     */
    public boolean getNotificationSetting(){
        return notifications;
    }
}