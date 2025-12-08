import java.util.HashMap;

public class CommandWords
{
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        validCommands.put("return", CommandWord.RETURN);
        validCommands.put("choose", CommandWord.CHOOSE);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("quit", CommandWord.QUIT);
    }

    /**
     * Find the CommandWord associated with a command string.
     * @param commandWord The word to look up (as a string).
     * @return The CommandWord corresponding to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        } else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for (String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }

    public static void commandDetails() {
        System.out.println("Here are the details about each command:");
        System.out.println("GO - Move in a specified direction (e.g., 'go north').");
        System.out.println("QUIT - Exit the game.");
        System.out.println("HELP - Display a help message.");
        System.out.println("BACK - Go back to the previous room.");
        System.out.println("LOOK - Look around the current room and get a description.");
        System.out.println("DETAILS - Show detailed information about each command.");
        System.out.println("?");
    }
}
