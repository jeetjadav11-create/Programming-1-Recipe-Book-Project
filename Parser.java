import java.util.Scanner;

public class Parser {
    private Scanner reader;

    public Parser() {
        reader = new Scanner(System.in);
    }

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

    public void showCommands() {
        System.out.println("Your command words are: return, choose, help, and quit.");
        System.out.println("RETURN - Brings the user back to the recip book from a recipe.");
        System.out.println("CHOOSE - Choose a recipe from the recipe book. The recipe must be specified after 'choose' and must not have any spaces if the recipe name has more than one word. (ex. Caprese Skewers -> CapreseSkewers)");
        System.out.println("HELP - Lists the acceptable commands and their descriptions");
        System.out.println("QUIT - Close the recipe book");
    }
}
