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

}
