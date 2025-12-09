import java.util.ArrayList;
/**
 * The driver class for the project.
 * Coded By: Gianluca Zambito
 */
public class RecipeBookMenu {
    private Parser parser;
    private RecipeBook recipeBook;
    private Recipe currentRecipe;

    public RecipeBookMenu(RecipeBook recipeBook) {
        parser = new Parser();
        this.recipeBook = recipeBook;
        currentRecipe = null;
        createRecipeBook();
    }
    
    //Sets this class as the main class. Do not use unless starting project outside of BlueJ.
    public static void main(String[] args) {
        RecipeBook recipeBook = new RecipeBook("Gianluca Zambito");
        RecipeBookMenu recipeBookMenu = new RecipeBookMenu(recipeBook);
        recipeBookMenu.open();
    }
    
    //Loads premade recipes into the recipe book.
    private void createRecipeBook() {
        //Caprese Skewers.
        Appetizer cS = new Appetizer("Caprese Skewers", "Gianluca Zambito", 10.0, 10);
        Ingredients cT = new Ingredients("Cherry Tomatoe", 20.0, Unit.NULL);
        cS.addIngredient(cT);
        Ingredients mB = new Ingredients("Mozzarella Ball", 10.0, Unit.NULL);
        cS.addIngredient(mB);
        cS.addInstruction("Thread the tomatoes and mozzarella balls onto mini wooden skewers. I like to use two cherry tomatoes and one mozzarella ball per skewer.");
        cS.addInstruction("Season them up, drizzle on the balsamic glaze, and enjoy!");
        
        //Chocolate Chip Mug Cake.
        Dessert cCMC = new Dessert("Chocolate Chip Mug Cake", "Gianluca Zambito", 1.0, 5.0);
        Ingredients eY = new Ingredients("Egg Yolk", 2.0, Unit.NULL);
        cCMC.addIngredient(eY);
        Ingredients butter = new Ingredients("Melted Butter", 1.0, Unit.TABLESPOON);
        cCMC.addIngredient(butter);
        Ingredients vE = new Ingredients("Vanilla Extract", 0.25, Unit.TEASPOON);
        cCMC.addIngredient(vE);
        Ingredients salt = new Ingredients("Salt", 0.125, Unit.TEASPOON);
        cCMC.addIngredient(salt);
        Ingredients sugar = new Ingredients("Sugar", 1.5, Unit.TABLESPOON);
        cCMC.addIngredient(sugar);
        Ingredients flour = new Ingredients("All-Purpose Flour", 3.0, Unit.TABLESPOON);
        cCMC.addIngredient(flour);
        Ingredients bS = new Ingredients("Baking Soda", 0.25, Unit.TEASPOON);
        cCMC.addIngredient(bS);
        Ingredients cC = new Ingredients("Chocolate Chip", 1.0, Unit.TABLESPOON);
        cCMC.addIngredient(cC);
        cCMC.addInstruction("Add egg yolk, melted butter, vanilla extract, and salt in a mug of your choosing, and stir well.");
        cCMC.addInstruction("Add flour, baking soda, and chocolate chips into the mug, and stir well.");
        cCMC.addInstruction("Put the mug in a microwave and bake for 1 minute.");
        cCMC.addInstruction("Enjoy!");
        
        recipeBook.addRecipe(cS);
        recipeBook.addRecipe(cCMC);
    }

    //Opens the menu.
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

    //Prints the opening line.
    private void printWelcome() {
        System.out.println("---- " + recipeBook.getAuthor() + "'s" + " Recipe Book ----");
        System.out.println();
    }
    
    //Processes the input commands and calls the required methods.
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
        
        //Gets the first command.
        CommandWord commandWord = CommandWord.fromString(command.getCommandWord());

        if (commandWord == null) {
            System.out.print("");
            return false;
        }
        
        //Checks to see if the command word matches any of the following cases, if so, runs the code within the case.
        switch (commandWord) {
            case RETURN:
                returnToRecipeBook();
                break;
            case CHOOSE:
                chooseRecipe(command);
                break;
            case SCALE:
                scaleRecipe(command);
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
    
    //Returns the user to the first page (the list of recipes).
    private void returnToRecipeBook(){
        if(currentRecipe != null){
            printWelcome();
            recipeBook.printAllRecipes();
            currentRecipe = null;
        }
        else{
            System.out.println("Already in recipe book.");
        }
    }
    
    //Chooses a recipe from the list of recipes.
    private void chooseRecipe(Command command){
        if(command.hasSecondWord()){
            if(currentRecipe == null){
                for(Recipe r : recipeBook.getRecipesList()){
                    String fixedName = r.getName().trim().toLowerCase().replaceAll("\\s","");
                    if(command.getSecondWord().equals(fixedName)){
                        recipeBook.printRecipe(r.getName());
                        currentRecipe = r;
                    }
                }
            }
            else{
                System.out.println(currentRecipe.getName() + " is currently chosen. Return to recipe book befre choosing another recipe.");
            }
        }
    }
    
    //Scales the amount of the ingredient(s) and servings in a recipe, and prints the modified list.
    private void scaleRecipe(Command command){
        if(command.hasSecondWord()){
            if(currentRecipe != null){
                double numberOfServingsNeeded = Double.parseDouble(command.getSecondWord());
                recipeBook.scaleRecipe(currentRecipe.getName(), numberOfServingsNeeded);
            }
            else{
                System.out.println("Not currently viewing a recipe. Use 'choose' to select a recipe.");
            }
        }
    }
    
    private void printHelp(){
        parser.showCommands();
    }
}
