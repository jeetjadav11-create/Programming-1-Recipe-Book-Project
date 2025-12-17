import java.util.Scanner;
/**
 * Reads the user inputs.
 * Coded By: Gianluca Zambito and Jeet Jadav
 */
public class Parser {
    private Scanner reader;

    public Parser() {
        reader = new Scanner(System.in);
    }

    public Scanner getReader(){
        return reader;
    }

    //Receives the command and checks if it has one or two words.
    public Command getCommand() {
        System.out.print("\n> ");
        String input = reader.nextLine().trim().toLowerCase();
        String[] words = input.split(" ");

        if (words.length == 0) {
            return new Command(null, null);
        } else if (words.length == 1) {
            return new Command(words[0], null);
        } else {
            return new Command(words[0], words[1]);
        }
    }

    //Prints the help lines.
    public void showCommands() {
        System.out.println("Your command words are: return, choose, scale, add, set, help, and quit.");
        System.out.println("RETURN - Brings the user back to the recip book from a recipe (ex. return).");
        System.out.println("CHOOSE (RECIPE) - Choose a recipe from the recipe book (ex. choose recipe).");
        System.out.println("SCALE (RECIPE) - Scale a recipe to match the number of servings needed (ex. scale recipe).");
        System.out.println("ADD - Add a recipe, ingredient, or instruction to a recipe or the recipe book. What to add must be specified after 'add' (ex. add ingredient).");
        System.out.println("REMOVE - Remove a recipe, ingredient, or instruction to a recipe or the recipe book. What to remove must be specified after 'remove' (ex. remove instruction).");
        System.out.println("SET (OWNER) - Set the owner to the recipe book (ex. set owner).");
        System.out.println("HELP - List the acceptable commands and their descriptions (ex. help).");
        System.out.println("PRINT ALL - Print all recipes with full details (ex. print all).");
        System.out.println("You can also use: back(return), select/ pick(choose), list/show/view(print), exit(quit).");
        System.out.println("FILTER (CATEGORY) - Show recipes by category (ex. filter dessert).");
        System.out.println("FAVORITE RECIPE - Mark the current recipe as favorite (ex. favorite recipe).");
        System.out.println("UNFAVORITE RECIPE - Remove favorite from current recipe (ex. unfavorite recipe).");
        System.out.println("PRINT FAVORITES - Print favorite recipes (ex. print favorites).");

        System.out.println("QUIT - Close the recipe book (ex. quit).");
    }
}
