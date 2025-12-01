import java.util.*;

public class Recipe{
    private String name;
    private String author;
    private List<Ingredients> ingredients;
    private HashMap<Integer, String> instructions;
    
    public Recipe(String name, String author){
        this.name = name;
        this.author = author;
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
    
    }
    
    public void addIngredients(){
        
    }
    
    public void addInstructions(){
        
    }
}
