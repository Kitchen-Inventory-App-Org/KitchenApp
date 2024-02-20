import java.util.Scanner;
import java.util.HashMap;
/**This class will drive the creation of a user
 */
public class UserCreation {

    static HashMap<String, String> userMap = new HashMap<String, String>();

    public static void main(String[] args) {
        UserCreation userCreation = new UserCreation();
        userCreation.welcomeUser();
    }
    /** Method to create a user
     * Method takes user input in the form of a string and replies with the user's name
     */
    public void registerUser(Scanner userCreation){
        System.out.println("Enter your username:");
        System.out.println("Username must be at least 5 characters long and contain no special characters");
        String username = userCreation.nextLine();
        System.out.println("Enter your password:");
        String password = userCreation.nextLine();
        if(username.length() >= 5 && username.matches("[a-zA-Z0-9]+")){
            userMap.put(username, password);
            System.out.println("User " + username + " created");
        } else {
            System.out.println("Invalid username");
        }
    }
    /** Method to welcome a user
     * Method takes user input in the form of a string and replies with a welcome message
     */
    public void welcomeUser(){
        System.out.println("Welcome!");
        Scanner userCreation = new Scanner(System.in);
        int choice = 0;
        while(choice != 3){
            System.out.println("Select an option:");
            System.out.println("1. Register a user");
            System.out.println("2. Login a user");
            System.out.println("3. Exit");
            choice = userCreation.nextInt();
            userCreation.nextLine();
            switch(choice){
                case 1:
                    registerUser(userCreation);
                    break;
                case 2:
                    loginUser(userCreation);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        userCreation.close();
    }
    /** Method to login a user
     * Method takes user input in the form of a string and replies with the user's name
     */
    public void loginUser(Scanner userCreation){
        System.out.println("Enter your username:");
        String username = userCreation.nextLine();
        System.out.println("Enter your password:");
        String password = userCreation.nextLine();
        if(userMap.containsKey(username) && userMap.get(username).equals(password)){
            System.out.println("Login successful");
            System.out.println("Welcome " + username);
        } else {
            System.out.println("Invalid username or password");
        }
    }
}

