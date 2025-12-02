import java.util.*;

/**
 * Coded By: Gianluca Zambito
 */
public class Recipe{
    private String name;
    private String author;
    private ArrayList<Ingredients> ingredients;
    private HashMap<Integer, String> instructions;
    
    public Recipe(String name, String author){
        this.name = name;
        this.author = author;
        ingredients = new ArrayList<>();
        instructions = new HashMap<>();
    }
    
    public String getName(){
        return name;
    }
    
    public String getAuthor(){
        return author;
    }
    
    //Prints all ingredients.
    public void printIngredients(){
        if (ingredients.isEmpty()) {
            //If th list ingredients is empty, then it will say that no ingredients can be printed.
            System.out.println("No ingredients have been added to " + getName() + " by " + getAuthor() + " yet.");
            return;
        }

        System.out.println("Ingredients in " + getName()  + " by " + getAuthor() +  ":");
        for (Ingredients i : ingredients) {
            //Prints the amount, unit, and name for each ingredient in list ingredients.
            System.out.println("- " + i.getAmount() + " " + i.getUnit() + "(s) of " + i.getName());
        }
    }
    
    //Prints all instructions.
    public void printInstructions(){
        if (instructions.isEmpty()) {
            //If the hash map instructions is empty, then it will say that no instructions can be printed.
            System.out.println("No instructions have been added for " + getName() + " by " + getAuthor() + " yet.");
            return;
        }
        
        System.out.println("Instructions for " + getName() + " by " + getAuthor() + ":");
        for (int step : instructions.keySet()) {
            //Prints the each key + 1 and their respective value(the instruction).
            System.out.println((step + 1) + ". " + instructions.get(step));
        }   
    }
    
    //Adds an ingredient to list ingredients.
    public void addIngredient(Ingredients ingredient){
        if(ingredient != null){
            for (Ingredients i : ingredients) {
                if(ingredient.equals(i) || (ingredient.getName()).equals(i.getName())){
                    //For each ingredient in ingredients, checks to see if it is the same or has the same name as the ingredients that is to be added. If so, then the code will not proceed.
                    System.out.println("Ingredient already exists in recipe.");
                    return;
                }
            }
            ingredients.add(ingredient);
        }
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
    
    //Scales the amount of the ingredient(s) and prints the modified list of ingredients.
    public void scaleRecipe(double amountToBeScaledBy){
        if(ingredients != null){
            for (Ingredients i : ingredients) {
                //For each ingredient in list ingredients, multiplies the current amount by the amount to be scaled by.
                i.setAmount(i.getAmount() * amountToBeScaledBy);
            }
            printIngredients();
            printInstructions();
            for (Ingredients i : ingredients) {
                //For each ingredient in list ingredients, brings the amount bak to what it was originally.
                i.setAmount(i.getAmount() / amountToBeScaledBy);
            }
        }
    }
}

