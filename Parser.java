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
        System.out.println("Your command words are: move, exit, assist, back, look, details");
    }
}
