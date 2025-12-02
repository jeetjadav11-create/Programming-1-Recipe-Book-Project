import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Coded By: Jeet Jadav
 */
public class IngredientsTest
{
    private Ingredients ingredient;

    public IngredientsTest()
    {
    }
         @BeforeEach
    public void setUp()
    {
        ingredient = new Ingredients("Flour", 3.0, UnitEnum.CUP);
    }
    
    @Test
    public void testGetName(){
        assertEquals("Flour", ingredient.getName());
    }
    
    @Test
    public void testGetAmount(){
        assertEquals(3.0, ingredient.getAmount());
    }
    
    @Test
    public void testGetUnit(){
        assertEquals(UnitEnum.CUP, ingredient.getUnit());
    }
    
    @Test
    public void testSetAmount(){
        ingredient.setAmount(1.0);
        assertEquals(1.0, ingredient.getAmount());
    }
}
