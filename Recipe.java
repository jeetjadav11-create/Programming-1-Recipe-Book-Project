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
        
    }
    
    public void printInstructions(){
        for (int step : instructions.keySet()) {
            System.out.println((step + 1) + ". " + instructions.get(step));
        }   
    }
    
    public void addIngredient(Ingredients ingredient){
        ingredients.add(ingredient);
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
}

