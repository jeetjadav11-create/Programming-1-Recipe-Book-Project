import java.util.ArrayList;
import java.util.Scanner;
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
        RecipeBook recipeBook = new RecipeBook("Uknown");
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
        System.out.println("------- " + recipeBook.getOwner() + "'s" + " Recipe Book -------");
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
            case ADD:
                addRecipe(command);
                addIngredient(command);
                addInstruction(command);
                break;
            case REMOVE:
                removeRecipe(command);
                removeIngredient(command);
                removeInstruction(command);
                break;
            case SET:
                setOwner(command);
                break;
            case HELP:
                printHelp();
                break;
            case QUIT:
                wantToQuit = true;
                break;
            case PRINT:
                printAll(command);
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
        Scanner reader = parser.getReader();
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("recipe")){
                if(currentRecipe == null){
                    System.out.println("Enter recipe name.");
                    String name = reader.nextLine();

                    System.out.println("Enter author name.");
                    String author = reader.nextLine();

                    for(Recipe r : recipeBook.getRecipesList()){
                        if(r.getName().equals(name) && r.getAuthor().equals(author)){
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
    }

    //Scales the amount of the ingredient(s) and servings in a recipe, and prints the modified list.
    private void scaleRecipe(Command command){
        Scanner reader = parser.getReader();
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("recipe")){
                if(currentRecipe != null){
                    System.out.println("Enter number of servings needed.");
                    double numberOfServingsNeeded = reader.nextDouble();
                    reader.nextLine();

                    recipeBook.scaleRecipe(currentRecipe.getName(), numberOfServingsNeeded);
                }
                else{
                    System.out.println("Not currently viewing a recipe. Use 'choose' to select a recipe.");
                }
            }
        }
    }

    //Adds a recipe to recipeBook.
    private void addRecipe(Command command){
        Scanner reader = parser.getReader();
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("recipe")){
                if(currentRecipe == null){
                    System.out.println("Enter recipe name");
                    String name = reader.nextLine();

                    System.out.println("Enter number of servings.");
                    double servings = reader.nextDouble();
                    reader.nextLine();

                    System.out.println("Enter total time to cook (in minutes).");
                    double time = reader.nextDouble();
                    reader.nextLine();

                    Recipe recipe = new Recipe(name, recipeBook.getOwner(), servings, time);
                    recipeBook.addRecipe(recipe);

                    printWelcome();
                    recipeBook.printAllRecipes();
                }
                else{
                    System.out.println("Must be in recipe book to add a recipe. Use 'return' to go to recipe book.");
                }
            }
        }
    }

    //Adds an ingredient to a recipe.
    private void addIngredient(Command command){
        Scanner reader = parser.getReader();
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("ingredient")){
                if(currentRecipe != null){
                    System.out.println("Enter ingredient name.");
                    String name = reader.nextLine();

                    System.out.println("Enter amount.");
                    double amount = reader.nextDouble();

                    Unit unit = null;
                    while(unit == null){
                        System.out.println("Enter unit of measurement.");
                        String unitInput = reader.nextLine();
                        try{
                            unit = Unit.valueOf(unitInput.toUpperCase());
                        }catch (IllegalArgumentException e) {
                            System.out.println("Invalid unit! Please enter one of: ");
                            for (Unit u : Unit.values()) {
                                System.out.println(" - " + u);
                            }
                        }
                    }

                    Ingredients ingredient = new Ingredients(name, amount, unit);
                    currentRecipe.addIngredient(ingredient);
                    recipeBook.printRecipe(currentRecipe.getName());
                }
                else{
                    System.out.println("Must be in a recipe to add an ingredient. Use 'choose' to go to a recipe.");
                }
            }
        }
    }

    //Adds an instruction to a recipe.
    private void addInstruction(Command command){
        Scanner reader = parser.getReader();
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("instruction")){
                if(currentRecipe != null){
                    System.out.println("Enter instruction.");
                    String instruction = reader.nextLine();

                    currentRecipe.addInstruction(instruction);
                    recipeBook.printRecipe(currentRecipe.getName());
                }
                else{
                    System.out.println("Must be in a recipe to add an instruction. Use 'choose' to go to a recipe.");
                }
            }
        }
    }

    //Removes a recipe from the recipe book.
    private void removeRecipe(Command command){
        Scanner reader = parser.getReader();
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("recipe")){
                if(currentRecipe == null){
                    System.out.println("Enter recipe name");
                    String name = reader.nextLine();

                    System.out.println("Enter author name");
                    String author = reader.nextLine();

                    boolean found = false;
                    Recipe toRemove = null;

                    for(Recipe r : recipeBook.getRecipesList()) {
                        if (r.getName().equals(name) && r.getAuthor().equals(author)) {
                            toRemove = r;
                            found = true;
                        }
                    }

                    if(found){
                        recipeBook.removeRecipe(toRemove);
                        printWelcome();
                        recipeBook.printAllRecipes();
                    }
                    else{
                        System.out.println("Recipe does not exist in recipe book.");
                    }
                }
                else{
                    System.out.println("Must be in recipe book to add a recipe. Use 'return' to go to recipe book.");
                }
            }
        }
    }

    //Removes an ingredient from a recipe.
    private void removeIngredient(Command command){
        Scanner reader = parser.getReader();
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("ingredient")){
                if(currentRecipe != null){
                    System.out.println("Enter ingredient name.");
                    String name = reader.nextLine();
                    boolean found = false;
                    Ingredients toRemove = null;

                    for(Ingredients i : currentRecipe.getIngredientsList()) {
                        if (i.getName().equalsIgnoreCase(name)) {
                            toRemove = i;
                            found = true;
                        }
                    }

                    if(found){
                        currentRecipe.removeIngredient(toRemove);
                        recipeBook.printRecipe(currentRecipe.getName());
                    }
                    else{
                        System.out.println("Ingredient does not exist in recipe.");
                    }
                }
                else{
                    System.out.println("Must be in a recipe to add an ingredient. Use 'choose' to go to a recipe.");
                }
            }
        }
    }

    //Removes an instruction from a recipe.
    private void removeInstruction(Command command){
        Scanner reader = parser.getReader();
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("instruction")){
                if(currentRecipe != null){
                    System.out.println("Enter instruction number.");
                    int number = reader.nextInt();
                    reader.nextLine();

                    currentRecipe.removeInstruction(number);
                    recipeBook.printRecipe(currentRecipe.getName());
                }
                else{
                    System.out.println("Must be in a recipe to add an ingredient. Use 'choose' to go to a recipe.");
                }
            }
        }
    }

    //Sets the owner to the recipe book.
    private void setOwner(Command command){
        Scanner reader = parser.getReader();
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("owner")){
                System.out.println("Enter new owner name.");
                String name = reader.nextLine();

                recipeBook.setOwner(name);
                printWelcome();
                recipeBook.printAllRecipes();
            }
        }
    }

    //Prints all recipes fully.
    private void printAll(Command command){
        if(command.hasSecondWord()){
            if(command.getSecondWord().equals("all")){
                for(Recipe r : recipeBook.getRecipesList()){
                    recipeBook.printRecipe(r.getName());
                    System.out.println();
                }
            }
            else{
                System.out.println("Print what? (ex. print all)");
            }
        }
        else{
            System.out.println("Print what? (ex. print all)");
        }
    }

    //Prints the help lines.
    private void printHelp(){
        parser.showCommands();
    }
}
