package symbol;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
