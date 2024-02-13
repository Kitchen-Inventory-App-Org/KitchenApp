import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FoodFileReader {
    public static void main(String[] args) {
        FoodFileReader foodFileReader = new FoodFileReader();
        foodFileReader.getUserInput();
    }
    public void getRecipe(String userInput){
        /** Method to look at a file and print line
         * Method takes user input in the form of a string and replies with the matched recipes in file
         */
        String line;
        Scanner sc = null;
        try {
            sc = new Scanner(new File("Food.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean foundRecipe = false;
        while(sc.hasNext()) {
            line = sc.nextLine();
            if (line.toLowerCase().contains(userInput.toLowerCase())) {
                System.out.println("Recipe found: " + line);
                foundRecipe = true;
            }
        }
        if(!foundRecipe){
            System.out.println("No recipe found");
        }
        sc.close();
    }
    public void getUserInput() {
        /** Method to take user input
         * Method takes user input in the form of a string and calls getFood method
         */
        System.out.println("What ingredient would you like to use?");
        Scanner getFood = new Scanner(System.in);
        String userInput = getFood.nextLine();
        getRecipe(userInput);
    }
}
