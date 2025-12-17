import java.util.*;
/**
 * The main class for recipes that stores all the methods.
 * Coded By: Gianluca Zambito
 */
public class Recipe{
    private String name;
    private String author;
    private double servings;
    private double totalTime;
    private ArrayList<Ingredients> ingredients;
    private HashMap<Integer, String> instructions;

    public Recipe(String name, String author, double servings, double totalTime){
        this.name = name;
        this.author = author;
        this.servings = servings;
        this.totalTime = totalTime;
        ingredients = new ArrayList<>();
        instructions = new HashMap<>();
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public double getServings(){
        return servings;
    }

    public double getTotalTime(){
        return totalTime;
    }

    public ArrayList<Ingredients> getIngredientsList(){
        return ingredients;
    }

    //Prints all ingredients.
    public void printIngredients(){
        if (ingredients.isEmpty()) {
            //If th list ingredients is empty, then it will say that no ingredients can be printed.
            System.out.println("No ingredients have been added to " + getName() + " by " + getAuthor() + " yet.");
            return;
        }

        System.out.println("Ingredients:");
        for (Ingredients i : ingredients) {
            //Prints the amount, unit, and name for each ingredient in list ingredients.
            if(i.getUnit() == Unit.NULL){
                System.out.println("- " + i.getAmount() + " " + i.getName() + "(s)");
            }
            else{
                System.out.println("- " + i.getAmount() + " " + i.getUnit() + "(s) of " + i.getName());
            }
        }
    }

    //Prints all instructions.
    public void printInstructions(){
        if (instructions.isEmpty()) {
            //If the hash map instructions is empty, then it will say that no instructions can be printed.
            System.out.println("No instructions have been added for " + getName() + " by " + getAuthor() + " yet.");
            return;
        }

        System.out.println("Instructions:");
        for (int step : instructions.keySet()) {
            //Prints the each key + 1 and their respective value(the instruction).
            System.out.println((step + 1) + ". " + instructions.get(step));
        }   
    }

    //Adds an ingredient to list ingredients.
    public boolean addIngredient(Ingredients ingredient){
        if(ingredient != null){
            for (Ingredients i : ingredients) {
                if(ingredient.equals(i) || (ingredient.getName()).equals(i.getName())){
                    //For each ingredient in ingredients, checks to see if it is the same or has the same name as the ingredients that is to be added. If so, then the code will not proceed.
                    System.out.println("Ingredient already exists in recipe.");
                    return false;
                }
            }
            ingredients.add(ingredient);
            return true;
        }
        return false;
    }

    //Adds an instruction and step number to hash map instructions.
    public void addInstruction(String instruction){
        instructions.put(instructions.size(), instruction);
    }

    //Removes an ingredient from list ingredients.
    public void removeIngredient(Ingredients ingredient){
        ingredients.remove(ingredient);
    }

    //Removes an instruction and its corresponding step number from hash map instructions.
    public void removeInstruction(int step){
        instructions.remove(step - 1);

        //Creates a new list named sortedSteps with the key sets from instructions and sorts it.
        List<Integer> sortedSteps = new ArrayList<>(instructions.keySet());
        Collections.sort(sortedSteps);

        //Creates a new hash map of the same types as instructions.
        HashMap<Integer, String> newMap = new HashMap<>();
        int newStep = 0;

        for (int oldStep : sortedSteps) {
            //For each old step in the list sortedSteps, adds/puts the value of hash map instruction as the value of hash map newMap, and the current value of newStep as the key of hash map newMap.
            newMap.put(newStep, instructions.get(oldStep));
            newStep++;
        }

        instructions = newMap;
    }

    //Scales the amount of the ingredient(s) and servings, and prints the modified list.
    public void scaleRecipe(double numberOfServingsNeeded){
        double difference = 0.0;
        if(numberOfServingsNeeded > 0){
            difference = numberOfServingsNeeded / servings;
        }

        if(ingredients != null){
            for (Ingredients i : ingredients) {
                //For each ingredient in list ingredients, multiplies the current amount by the amount to be scaled by.
                i.setAmount(i.getAmount() * difference);
            }
            servings = numberOfServingsNeeded;

            System.out.println("---- " + name + " by " + author + " ----");
            System.out.println("");
            System.out.println("Total Time: " + totalTime + " minute(s)");
            System.out.println("");
            System.out.println("Servings: " + servings);
            System.out.println("");
            printIngredients();
            System.out.println("");
            printInstructions();

            for (Ingredients i : ingredients) {
                //For each ingredient in list ingredients, brings the amount bak to what it was originally.
                i.setAmount(i.getAmount() / difference);
            }
            servings = servings / difference;
        }
    }

    public HashMap<Integer, String> getInstructions() {
        return instructions;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Recipe other = (Recipe) obj;
        return name.equals(other.name) && author.equals(other.author);
    }

    @Override
    public String toString() {
        return name + " by " + author + " (" + servings + " servings, " + totalTime + " min)";
    }

}
