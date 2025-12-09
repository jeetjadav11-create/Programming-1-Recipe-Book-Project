/**
 * Coded By: Gianluca Zambito and Jeet Jadav
 */
public enum CommandWord {
    RETURN("return"),
    CHOOSE("choose"),
    HELP("help"),
    QUIT("quit"),
    SCALE("scale"),
    UNKNOWN("unknown");
    
    
    private String command;

    CommandWord(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    //turns inputs into a command enum.
    public static CommandWord fromString(String command) {
        for (CommandWord c : CommandWord.values()) {
            if (c.getCommand().equalsIgnoreCase(command)) {
                return c;
            }
        }
        return null;
    }
}
