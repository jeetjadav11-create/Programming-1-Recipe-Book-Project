import java.util.*;

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
    
    public void printIngredients(){
        if (ingredients.isEmpty()) {
            System.out.println("No ingredients have been added to " + getName() + " by " + getAuthor() + " yet.");
            return;
        }

        System.out.println("Ingredients in " + getName()  + " by " + getAuthor() +  ":");
        for (Ingredients i : ingredients) {
            System.out.println("- " + i.getAmount() + " " + i.getUnit() + "(s) of " + i.getName());
        }
    }
    
    public void printInstructions(){
        if (instructions.isEmpty()) {
            System.out.println("No instructions have been added for " + getName() + " by " + getAuthor() + " yet.");
            return;
        }
        
        System.out.println("Instructions for " + getName() + " by " + getAuthor() + ":");
        for (int step : instructions.keySet()) {
            System.out.println((step + 1) + ". " + instructions.get(step));
        }   
    }
    
    public void addIngredient(Ingredients ingredient){
        if(ingredient != null){
            for (Ingredients i : ingredients) {
                if(ingredient.equals(i)){
                    System.out.println("Ingredient already exists in recipe.");
                    return;
                }
            }
            ingredients.add(ingredient);
        }
    }
    
    public void addInstruction(String instruction){
        instructions.put(instructions.size(), instruction);
    }
    
    public void removeIngredient(Ingredients ingredient){
        ingredients.remove(ingredient);
    }
    
    public void removeInstruction(int step){
        instructions.remove(step - 1);

        List<Integer> sortedSteps = new ArrayList<>(instructions.keySet());
        Collections.sort(sortedSteps);

        HashMap<Integer, String> newMap = new HashMap<>();
        int newStep = 0;

        for (int oldStep : sortedSteps) {
            newMap.put(newStep, instructions.get(oldStep));
            newStep++;
        }

        instructions = newMap;
    }
    
    public void scaleRecipe(double amountToBeScaledBy){
        if(ingredients != null){
            for (Ingredients i : ingredients) {
                i.setAmount(i.getAmount() * amountToBeScaledBy);
            }
            printIngredients();
            printInstructions();
            for (Ingredients i : ingredients) {
                i.setAmount(i.getAmount() / amountToBeScaledBy);
            }
        }
    }
}

