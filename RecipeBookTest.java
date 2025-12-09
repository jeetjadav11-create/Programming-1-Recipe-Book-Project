import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The test class for RecipeBook.
 * Coded By: Gianluca Zambito
 */
public class RecipeBookTest
{
    private RecipeBook recipeBook;
    
    private Dessert cCake;
    private Ingredients ingredient1CCake;
    private Ingredients ingredient2CCake;
    
    private Entree omelet;
    private Ingredients ingredient1Omelet;
    private Ingredients ingredient2Omelet;

    public RecipeBookTest()
    {
    }

    @BeforeEach
    public void setUp()
    {
        recipeBook = new RecipeBook("Gianluca Zambito");
        cCake = new Dessert("Chocolate Cake", "Gianluca Zambito", 10.0, 5.0);
    }
    
    @Test
    public void testGetAuthor(){
        assertEquals("Gianluca Zambito", recipeBook.getAuthor());
    }
    
    @Test
    public void testAddRecipe(){
        recipeBook.addRecipe(cCake);
        assertEquals(1, recipeBook.getRecipesList().size());
        
        recipeBook.addRecipe(cCake);
        assertEquals(1, recipeBook.getRecipesList().size());
    }
    
    @Test
    public void testRemoveRecipe(){
        recipeBook.addRecipe(cCake);
        recipeBook.removeRecipe(cCake);
        assertEquals(0, recipeBook.getRecipesList().size());
    }
    
    @Test
    public void testPrintRecipe(){
        recipeBook.addRecipe(cCake);
        assertEquals(true, recipeBook.printRecipe("Chocolate Cake"));
        
        assertEquals(false, recipeBook.printRecipe("Omelet"));
    }
    
    @Test
    public void testScaleRecipe(){
        assertEquals(false, recipeBook.scaleRecipe("Omelet", 2));
        
        recipeBook.addRecipe(cCake);
        assertEquals(true, recipeBook.scaleRecipe("Chocolate Cake", 2));
    }
}
