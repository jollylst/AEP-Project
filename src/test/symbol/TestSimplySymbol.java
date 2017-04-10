package symbol;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    @Test
    public void testHashCodePerfect() {
        /** Write a test that ensures the hashCode is perfect,
         meaning no two SimpleSymbol should EVER have the same hashCode!
         */
        SimpleSymbol[] ssA = new SimpleSymbol[8];
        ssA[0] = new SimpleSymbol(10, 20, 50);
        ssA[1] = new SimpleSymbol(20, 50, 10);
        ssA[2] = new SimpleSymbol(50, 15, 15);
        ssA[3] = new SimpleSymbol(40, 20, 20);
        ssA[4] = new SimpleSymbol(30, 25, 25);
        ssA[5] = new SimpleSymbol(15, 25, 40);
        ssA[6] = new SimpleSymbol(5, 60, 15);
        ssA[7] = new SimpleSymbol(70, 5, 5);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            hashSet.add(ssA[i].hashCode());
        }
        assertEquals(8, hashSet.size());
    }

    @Test
    public void testHashCodeDeterministic() {
        SimpleSymbol ss = SimpleSymbol.randomSimpleSymbol();
        int hashCode = ss.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, ss.hashCode());
        }
    }

    @Test
    public void testRandomSymbolsHashCodeSpread() {
        List<Symbol> symbols = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            symbols.add(SimpleSymbol.randomSimpleSymbol());
        }

        assertTrue(SymbolTestUtility.haveNiceHashCodeSpread(symbols, 10));
    }
}
