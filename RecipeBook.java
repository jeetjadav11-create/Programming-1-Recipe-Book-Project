import java.util.*;
import java.util.ArrayList;
public class RecipeBook{
    private String author;
    private ArrayList<Recipe> recipes;

    public RecipeBook(String author){
        this.author = author;
        recipes = new ArrayList<>();
    }

    public String getAuthor(){
        return author;
    }

    public void printRecipe(String recipeName){
        if(!recipes.isEmpty()){
            for (Recipe r : recipes ){
                if (r.getName().equals(recipeName)){
                    r.printIngredients();
                    r.printInstructions();
                }
            }
        }
    }

    public void printAllRecipes(){
        if (recipes.isEmpty()) {
            System.out.println("No recipes in the book.");
            return;
        }

        for (Recipe r : recipes) {
            System.out.println("- " + r.getName() + " by " + r.getAuthor());
        }
    }

    public void addRecipe(Recipe recipe){
        if (recipe != null) {
            for (Recipe r : recipes) {
                if(recipe.equals(r)){
                    System.out.println("Recipe already exists in book.");
                    return;
                }
            }
            recipes.add(recipe);  
        }
    }

    public void removeRecipe(Recipe recipe){
        recipes.remove(recipe);
    }
    
    public void scaleRecipe(String recipeName, double amountToBeScaledBy){
        if(!recipes.isEmpty()){
            for (Recipe r : recipes ){
                if (r.getName().equals(recipeName)){
                    r.scaleRecipe(amountToBeScaledBy);
                }
            }
        }
    }
}
