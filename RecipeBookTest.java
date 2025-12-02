import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
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
        
        cCake = new Dessert("Chocolate Cake", "Gianluca Zambito");
        ingredient1CCake = new Ingredients("Flour", 2.0, UnitEnum.CUP);
        ingredient2CCake = new Ingredients("Cocoa Powder", 1.0, UnitEnum.CUP);
        
        omelet = new Entree("Omelet", "Gianluca Zambito");
        ingredient1Omelet = new Ingredients("Egg", 0.15, UnitEnum.LITRE);
        ingredient1Omelet = new Ingredients("Salt", 0.5, UnitEnum.TEASPOON);
    }
    
    @Test
    public void test(){
        
    }
    
    @Test
    public void testgetAuthor(){
        assertEquals("Gianluca Zambito", recipeBook.getAuthor());
    }
}
