 
public class RegisterNewUser {
    // Username Length
    public static final int MIN_LENGTH_USERNAME = 6;
    public static final int MAX_LENGTH_USERNAME = 20;

    // Password Length
    public static final int MIN_LENGTH_PASSWORD = 8;
    public static final int MAX_LENGTH_PASSWORD = 32;

    // Existing Users
    public static String[] existingUsernames = {"newuser1", "newuser2", "newuser3"};

    /*

    Username Methods

     */

    /***
     * Checks if the username falls within the specified length.
     *
     * @param username
     * @return true if the username is within range, false otherwise
     */
    public static boolean checkUsernameLength(String username) {
        return MIN_LENGTH_USERNAME <= username.length() && MAX_LENGTH_USERNAME >= username.length();
    }

    /***
     * Checks if the username already exists.
     *
     * @param username
     * @return true if the username exists, false otherwise
     */
    public static boolean checkExists(String username) {
        for (String user : existingUsernames) {
            if (username.equals(user)) {
                return true;
            }
        }

        return false;
    }

    /***
     * Checks if the username is alphanumeric (plus underscores). No other characters allowed.
     *
     * @param username
     * @return true if the username contains all valid characters, false otherwise
     */
    public static boolean checkValidUsername(String username) {
        for (char c : username.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isAlphabetic(c) && c != '_') {
                return false;
            }
        }

        return true;
    }

    /*

    Password methods

     */

    /***
     * Checks if the password length falls within range.
     *
     * @param password
     * @return
     */
    public static boolean checkPasswordLength(String password) {
        return MIN_LENGTH_PASSWORD <= password.length() && MAX_LENGTH_PASSWORD >= password.length();
    }

    /***
     * Checks if the password is valid. (Contains a capital letter and a number)
     *
     * @param password
     * @return
     */
    public static boolean checkValidPassword(String password) {
        // Password must contain a capital letter and number.
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;

        char[] passwordChars = password.toCharArray();

        // Check for capital letters and numbers
        for (char c : passwordChars) {
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
            }
            else if (Character.isDigit(c)) {
                hasNumber = true;
            }
        }

        return hasCapitalLetter && hasNumber;
    }

    /***
     * Checks if the two passwords are matching.
     *
     * @param password1
     * @param password2
     * @return
     */
    public static boolean checkMatchingPasswords(String password1, String password2) {
        return password1.equals(password2);
    }

    public static String registerUser(String username, String password, String password2) {
        if (!checkUsernameLength(username)) {
            return "Username length does not fall within the range.";
        }
        if (checkExists(username)) {
            return "A user with that username already exists.";
        }
        if (!checkValidUsername(username)) {
            return "The username contains invalid characters.";
        }

        if (!checkPasswordLength(password)) {
            return "Password length does not fall within the range.";
        }
        if (!checkValidPassword(password)) {
            return "Password does not satisfy all requirements.";
        }
        if (!checkMatchingPasswords(password, password2)) {
            return "Passwords do not match.";
        }

        return "Registration Successful!";
    }
}
