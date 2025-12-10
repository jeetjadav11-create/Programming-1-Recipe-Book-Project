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
        assertEquals("Gianluca Zambito", recipeBook.getOwner());
    }
    
    @Test
    public void testAddRecipe(){
        assertEquals(true, recipeBook.addRecipe(cCake));
        
        assertEquals(false, recipeBook.addRecipe(cCake));
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
        recipeBook.addRecipe(cCake);
        recipeBook.scaleRecipe("Chocolate Cake", 20);
        assertEquals(20, cCake.getServings());
        
        assertEquals(false, recipeBook.scaleRecipe("Chocolate Cake", -20));
    }
}
