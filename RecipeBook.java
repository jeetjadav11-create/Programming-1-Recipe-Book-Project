import java.util.*;

public class RecipeBook{
    private String author;
    private List<Recipe> recipes;

    public RecipeBook(String author){
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public void printRecipe(){

    }

    public void printAllRecipes(){
        if (recipes.isEmpty()) {
            System.out.println("No recipes in the book.");
            return;
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
