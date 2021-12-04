import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Test
{
    public static void main(String args[]){
        String username; //Username to be typed in
        String password; //Initial password to be typed in
        String password2; //Retyped password to match up with initially typed password
        String message; //Holds the message of whether or not an account is created
        String assignmentName; //Holds name of assignment
        int assignmentDueDate; //Holds how many days from today the assignment is due
        int assignmentHours; //Holds how many hours the assignment will take
        Scanner kbd = new Scanner(System.in); //For receiving keyboard input

        RegisterNewUser user1 = new RegisterNewUser(); //Holds the new user info

        //Testing the RegisterNewUser class
        
        System.out.println("Enter username:");

        username = kbd.next();
        System.out.println("Enter password:");
        password = kbd.next();
        System.out.println("Retype password:");
        password2 = kbd.next();

        message = user1.registerUser(username,password,password2);
        System.out.println(message);
        
        
        //Testing the Assignment class

        System.out.println("Type in name of assignment:");
        assignmentName = kbd.next();
        System.out.println("Type in how many days from today assignment is due:");
        assignmentDueDate = kbd.nextInt();
        System.out.println("Type in how many hours the assignment will take:");
        assignmentHours = kbd.nextInt();

        Assignment assignment1 = new Assignment(assignmentName,LocalDateTime.now().plusDays(assignmentDueDate),assignmentHours);

        System.out.println("Due date: "+assignment1.getDueDate());
        System.out.println("Hours to complete "+assignmentName+": "+assignment1.getHoursToComplete());
        
        //Testing the ScheduleGenerator class
        
        ScheduleGenerator schedule1 = new ScheduleGenerator();
        System.out.println("Set schedule name: ");
        schedule1.setScheduleName(kbd.next());
        System.out.println("Set whether you want notifications (true or false):");
        schedule1.setNotifications(kbd.nextBoolean());
        System.out.println("Schedule name set to: " + schedule1.getScheduleName());
        System.out.println("Notifications set to: " + schedule1.getNotificationSetting());
        System.out.println("Displaying if due date in the future:");
        System.out.println(schedule1.addAssignment(assignment1));
        System.out.println();

        Assignment assignment2 = new Assignment(assignmentName,LocalDateTime.now().minusDays(assignmentDueDate),assignmentHours);

        System.out.println("Displaying if due date in the past:");
        System.out.println(schedule1.addAssignment(assignment2));
    }
}
