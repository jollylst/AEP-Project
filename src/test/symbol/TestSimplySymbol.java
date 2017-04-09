package symbol;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Jolly on 4/9/17.
 */
public class TestSimplySymbol {
    @Test
    public void testEquals() {
        SimpleSymbol ooA = new SimpleSymbol(5, 10, 20);
        SimpleSymbol ooA2 = new SimpleSymbol(5, 10, 20);
        SimpleSymbol ooB = new SimpleSymbol(50, 50, 50);
        assertEquals(ooA, ooA2);
        assertNotEquals(ooA, ooB);
        assertNotEquals(ooA2, ooB);
        assertEquals(ooA, "ketchup");
    }

}
