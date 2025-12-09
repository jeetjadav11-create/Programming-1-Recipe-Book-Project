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
