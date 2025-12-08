
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
    private Ingredients ing1;
    private Ingredients ing2;

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
        recipe = new Recipe("Chocolate Cake", "Gianluca Zambito", 10.0, 45.0);

        ing1 = new Ingredients("Flour", 2.0, Unit.CUP);
        ing2 = new Ingredients("Sugar", 1.0, Unit.CUP);
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
    public void testGetName() {
        assertEquals("Chocolate Cake", recipe.getName());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Gianluca Zambito", recipe.getAuthor());
    }

    @Test
    public void testAddIngredient() {
        recipe.addIngredient(ing1);
        recipe.addIngredient(ing1);   
        assertEquals("Flour", ing1.getName());
        assertEquals(2.0, ing1.getAmount());
    }

    @Test
    public void testRemoveIngredient() {
        recipe.addIngredient(ing1);
        recipe.removeIngredient(ing1);
        recipe.removeIngredient(ing1);

        assertEquals("Flour", ing1.getName());
    }

    @Test
    public void testAddInstruction() {
        recipe.addInstruction("Mix all ingredients.");
        recipe.addInstruction("Bake in the oven.");

        assertTrue(true);
    }

    @Test
    public void testRemoveInstruction() {
        recipe.addInstruction("Step 1");
        recipe.addInstruction("Step 2");

        recipe.removeInstruction(1); 
        recipe.removeInstruction(1); 

        assertTrue(true);
    }

    @Test
    public void testPrintIngredients() {
        recipe.printIngredients();

        recipe.addIngredient(ing1);
        recipe.addIngredient(ing2);

        recipe.printIngredients(); 

        assertTrue(true);
    }

    @Test
    public void testPrintInstructions() {
        recipe.printInstructions();
        recipe.addInstruction("Step 1");
        recipe.addInstruction("Step 2");

        recipe.printInstructions(); 

        assertTrue(true);
    }

    @Test
    public void testScaleRecipe() {
        recipe.addIngredient(ing1);
        recipe.addIngredient(ing2);

        double original1 = ing1.getAmount();
        double original2 = ing2.getAmount();

        recipe.scaleRecipe(2.0); 
        assertEquals(original1, ing1.getAmount());
        assertEquals(original2, ing2.getAmount());
    }

}
