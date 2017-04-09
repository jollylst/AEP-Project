package symbol;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashSet;

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

    @Test
    public void testHashCodeAndEqualsConsistency() {
        SimpleSymbol ssA = new SimpleSymbol(5, 10, 20);
        SimpleSymbol ssB = new SimpleSymbol(5, 10, 20);
        HashSet<SimpleSymbol> hashSet = new HashSet<>();
        hashSet.add(ssA);
        assertTrue(hashSet.contains(ssB));
    }

    @Test
    public void testHashCodeImperfect() {
        SimpleSymbol[] ssA = new SimpleSymbol[5];
        ssA[0] = new SimpleSymbol(10, 20, 50);
        ssA[1] = new SimpleSymbol(25, 50, 10);
        ssA[2] = new SimpleSymbol(50, 15, 105);
        ssA[3] = new SimpleSymbol(60, 20, 20);
        ssA[4] = new SimpleSymbol(85, 25, 25);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            hashSet.add(ssA[i].hashCode());
        }
        assertEquals(5, hashSet.size());
    }
}
