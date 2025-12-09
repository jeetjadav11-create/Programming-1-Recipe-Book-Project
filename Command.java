/**
 * Coded By: Gianluca Zambito and Jeet Jadav
 */
public class Command {
    private String commandWord;
    private String secondWord;

    public Command(String commandWord, String secondWord){
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord(){
        return commandWord;
    }

    public String getSecondWord(){
        return secondWord;
    }

    public boolean hasSecondWord(){
        return secondWord != null;
    }
}
