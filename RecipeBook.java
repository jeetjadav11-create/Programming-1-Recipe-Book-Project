import java.util.*;
import java.util.ArrayList;

/**
 * Coded By: Jeet Jadav
 */
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

    //Prints the ingredients and instructions of a given recipe in the book.
    public void printRecipe(String recipeName){
        if(!recipes.isEmpty()){
            for (Recipe r : recipes ){
                if (r.getName().equals(recipeName)){
                    //For each recipe in recipes, if the name matches the name of the given recipe, then print it's ingredients and instructions.
                    r.printIngredients();
                    r.printInstructions();
                }
            }
        }
    }

    //Prints the name and author of all recipes in the book.
    public void printAllRecipes(){
        if (!recipes.isEmpty()) {
            for (Recipe r : recipes) {
                //For each recipe in recipes, prints the name and author.
                System.out.println("- " + r.getName() + " by " + r.getAuthor());
            }
        }
        else{
            //If recipes is empty, print no recipes in the book.
            System.out.println("No recipes in the book.");
        }
    }

    //Adds a recipe to list recipes.
    public void addRecipe(Recipe recipe){
        if (recipe != null) {
            for (Recipe r : recipes) {
                if(recipe.equals(r)){
                    //For each recipe in recipes, if it matches with the recipe to be added, then stops the code from proceeding.
                    System.out.println("Recipe already exists in book.");
                    return;
                }
            }
            recipes.add(recipe);  
        }
    }

    //Removes a recipe from list recipes.
    public void removeRecipe(Recipe recipe){
        recipes.remove(recipe);
    }
    
    //Calls the method scaleRecipe from Recipe.
    public void scaleRecipe(String recipeName, double amountToBeScaledBy){
        if(!recipes.isEmpty()){
            for (Recipe r : recipes ){
                if (r.getName().equals(recipeName)){
                    //For each recipe in recipes, if its name matches with the name given, then calls the method scaleRecipe from Recipe.
                    r.scaleRecipe(amountToBeScaledBy);
                }
            }
        }
    }
}
