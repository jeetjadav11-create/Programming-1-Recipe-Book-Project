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

    public void printRecipe(String name){
        for (Recipe r : recipes ){
            if (r.getName().equals(name)){
                r.printIngredients();
                r.printInstructions();

            }

        }
    }

    public void printAllRecipes(){
        if (recipes.isEmpty()) {
            System.out.println("No recipes in the book.");
            return;
        }

        System.out.println("Recipes by " + author + ":");
        for (Recipe r : recipes) {
            System.out.println("- " + r.getName());
        }
    }

    public void addRecipe(Recipe r){
        if (r != null) {
            recipes.add(r);  
        }
    }

    public void removeRecipe(Recipe r){
        recipes.remove(r);
    }
}
