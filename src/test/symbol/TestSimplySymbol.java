package symbol;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Jolly on 4/9/17.
 */
public class TestSimplySymbol {
    @Test(expected = IllegalArgumentException.class)
    public void colorValueBeyondLimitShouldNotBeCreatable() {
        SimpleSymbol ooA = new SimpleSymbol(5, 10, 265);
    }

    @Test(expected = IllegalArgumentException.class)
    public void colorValueNotMultiplesOfFiveShouldNotBeCreatable() {
        SimpleSymbol ooA = new SimpleSymbol(10, 22, 125);
    }

    @Test
    public void testEquals() {
        SimpleSymbol ssA = new SimpleSymbol(5, 10, 20);
        SimpleSymbol ssA2 = new SimpleSymbol(5, 10, 20);
        SimpleSymbol ssB = new SimpleSymbol(50, 50, 50);
        assertEquals(ssA, ssA2);
        assertNotEquals(ssA, ssB);
        assertNotEquals(ssA2, ssB);
        assertNotEquals(ssA, "ketchup");
    }



}
