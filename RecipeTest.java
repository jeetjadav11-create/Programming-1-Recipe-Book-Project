

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeTest.
 *
 * @author Jeet Jadav
 * @version (a version number or a date)
 */
public class RecipeTest
{
    private Recipe recipe;
    private Ingredients flour;
    private Ingredients milk;
    private Ingredients egg;
    
    /**
     * Default constructor for test class RecipeTest
     */
    public RecipeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
           recipe = new Recipe("Pancakes", "Jeet");
    flour = new Ingredients("Flour", 2.0, UnitEnum.CUP);
    milk  = new Ingredients("Milk", 1.5, UnitEnum.CUP);
    egg   = new Ingredients("Egg", 2, UnitEnum.CUP); 
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    @Test
      public static void main(String[] args) {

        // ---------- Test Constructor, getName, getAuthor ----------
        System.out.println("=== Testing Constructor, getName(), getAuthor() ===");
        Recipe r = new Recipe("Pancakes", "Jeet");
        System.out.println("Name: " + r.getName());
        System.out.println("Author: " + r.getAuthor());
        System.out.println();
    }
    
}
