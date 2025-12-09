import java.util.*;
import java.util.ArrayList;
/**
 * Stores all the recipes into one object.
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
    
     public ArrayList<Recipe> getRecipesList(){
        return recipes;
    }

    //Prints the ingredients and instructions of a given recipe in the book.
    public boolean printRecipe(String recipeName){
        if(!recipes.isEmpty()){
            for (Recipe r : recipes ){
                if (r.getName().equals(recipeName)){
                    //For each recipe in recipes, if the name matches the name of the given recipe, then print it's ingredients and instructions.
                    System.out.println("---- " + r.getName() + " by " + r.getAuthor() + " ----");
                    System.out.println("");
                    System.out.println("Total Time: " + r.getTotalTime() + " minute(s)");
                    System.out.println("");
                    System.out.println("Servings: " + r.getServings());
                    System.out.println("");
                    r.printIngredients();
                    System.out.println("");
                    r.printInstructions();
                    return true;
                }
            }
        }
        return false;
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
    public boolean addRecipe(Recipe recipe){
        if(recipe != null) {
            for(Recipe r : recipes) {
                if(recipe.equals(r)){
                    //For each recipe in recipes, if it matches with the recipe to be added, then stops the code from proceeding.
                    System.out.println("Recipe already exists in book.");
                    return false;
                }
            }
            recipes.add(recipe);
            return true;
        }
        return false;
    }

    //Removes a recipe from list recipes.
    public void removeRecipe(Recipe recipe){
        recipes.remove(recipe);
    }
    
    //Scales the amount of the ingredient(s) and servings in a recipe, and prints the modified list.
    public boolean scaleRecipe(String recipeName, double amountToBeScaledBy){
        if(!recipes.isEmpty() || amountToBeScaledBy <= 0){
            for (Recipe r : recipes ){
                if (r.getName().equals(recipeName)){
                    //For each recipe in recipes, if its name matches with the name given, then calls the method scaleRecipe from Recipe.
                    r.scaleRecipe(amountToBeScaledBy);
                    return true;
                }
            }
        }
        System.out.println("No recipes have been added yet or the amountToBeScaledBy is less than or equal to 0.");
        return false;
    }
}
