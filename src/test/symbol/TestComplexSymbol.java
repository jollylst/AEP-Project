package symbol;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jolly on 4/9/17.
 */
public class TestComplexSymbol {
    @Test
    public void testHashCodeDeterministic() {
        ComplexSymbol so = ComplexSymbol.randomComplexSymbol();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }

    /* This should pass if your SymbolTestUtility.haveNiceHashCodeSpread
       is correct. */
    @Test
    public void testRandomSymbolHashCodeSpread() {
        List<Symbol> symbols = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            symbols.add(ComplexSymbol.randomComplexSymbol());
        }

        assertTrue(SymbolTestUtility.haveNiceHashCodeSpread(symbols, 10));
    }
}
