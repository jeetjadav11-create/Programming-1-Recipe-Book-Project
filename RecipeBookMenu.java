import java.util.ArrayList;

public class RecipeBookMenu {
    private Parser parser;
    private RecipeBook recipeBook;
    private Recipe currentRecipe;

    public RecipeBookMenu(String ownerName) {
        parser = new Parser();
        recipeBook = new RecipeBook(ownerName);
        currentRecipe = null;
        createRecipeBook();
    }

    private void createRecipeBook() {
        Appetizer cS = new Appetizer("Caprese Skewers", "Gianluca Zambito");
        Ingredients cT = new Ingredients("Cherry Tomatoe", 20.0, Unit.NULL);
        cS.addIngredient(cT);
        Ingredients mB = new Ingredients("Mozzarella Ball", 10.0, Unit.NULL);
        cS.addIngredient(mB);
        cS.addInstruction("Thread the tomatoes and mozzarella balls onto mini wooden skewers. I like to use two cherry tomatoes and one mozzarella ball per skewer.");
        cS.addInstruction("Season them up, drizzle on the balsamic glaze, and enjoy!");
        recipeBook.addRecipe(cS);
        
        Entree sF = new Entree("Stir Fry", "Gianluca Zambito");
        Ingredients cB = new Ingredients("Chicken Breast", 453.5, Unit.GRAM);
        sF.addIngredient(cB);
        Ingredients yBP = new Ingredients("Yellow Bell Pepper", 0.5, Unit.NULL);
        sF.addIngredient(yBP);
        recipeBook.addRecipe(sF);
    }

    public void open() {
        printWelcome();
        recipeBook.printAllRecipes();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Closing recipe book.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("---- " + recipeBook.getAuthor() + "'s" + " Recipe Book ----");
        System.out.println();
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
    
        CommandWord commandWord = CommandWord.fromString(command.getCommandWord());

        if (commandWord == null) {
            System.out.print("");
            return false;
        }
    
        switch (commandWord) {
            case RETURN:
                
                break;
            case CHOOSE:
                chooseRecipe(command);
                break;    
            case HELP:
                printHelp();
                break;
            case QUIT:
                wantToQuit = true;
                break;
            default:
                System.out.println("Command not recognized.");
                parser.showCommands();
                break;
        }
        return wantToQuit;
    }
    
    private void chooseRecipe(Command command){
        if(command.hasSecondWord()){
            for(Recipe r : recipeBook.getRecipesList()){
                String fixedName = r.getName().trim().toLowerCase().replaceAll("\\s","");
                if(command.getSecondWord().equals(fixedName)){
                    recipeBook.printRecipe(r.getName());
                }
            }
        }
    }
    
    private void printHelp(){
        parser.showCommands();
    }
}
