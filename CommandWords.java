import java.util.HashMap;
/**
 * Checks for valid commands and converts them into enum values.
 * Coded By: Gianluca Zambito and Jeet Jadav
 */
public class CommandWords
{
    private HashMap<String, CommandWord> validCommands;

    public CommandWords()
    {
        validCommands = new HashMap<>();
        validCommands.put("return", CommandWord.RETURN);
        validCommands.put("choose", CommandWord.CHOOSE);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("scale", CommandWord.SCALE);
        validCommands.put("add", CommandWord.ADD);
        validCommands.put("remove", CommandWord.REMOVE);
        validCommands.put("set", CommandWord.SET);
        validCommands.put("print", CommandWord.PRINT);
        validCommands.put("back", CommandWord.RETURN);
        validCommands.put("list", CommandWord.PRINT);
        validCommands.put("show", CommandWord.PRINT);
        validCommands.put("view", CommandWord.PRINT);
        validCommands.put("select", CommandWord.CHOOSE);
        validCommands.put("pick", CommandWord.CHOOSE);
        validCommands.put("exit", CommandWord.QUIT);
        validCommands.put("leave", CommandWord.QUIT);
        validCommands.put("filter", CommandWord.FILTER);
        validCommands.put("favorite", CommandWord.FAVORITE);
        validCommands.put("unfavorite", CommandWord.UNFAVORITE);


    }
    //Converts an input command into the right enum value.
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        } else {
            return CommandWord.UNKNOWN;
        }
    }

    //Checks if the input is a command.
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
}
