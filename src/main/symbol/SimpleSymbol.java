package symbol;

import edu.princeton.cs.algs4.StdRandom;
/**
 * Created by Jolly on 4/9/17.
 */
public class SimpleSymbol {
    protected int red;
    protected int green;
    protected int blue;

    private static final double WIDTH = 0.01;
    private static final boolean USE_PERFECT_HASH = true;

    public SimpleSymbol(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException();
        }
        if ((r % 5 != 0) || (g % 5 != 0) || (b % 5 != 0)) {
            throw new IllegalArgumentException("red/green/blue values must all be multiples of 5!");
        }
        red = r;
        green = g;
        blue = b;
    }

    public static SimpleSymbol randomSimpleSymbol() {
        int red = StdRandom.uniform(0, 51) * 5;
        int green = StdRandom.uniform(0, 51) * 5;
        int blue = StdRandom.uniform(0, 51) * 5;
        return new SimpleSymbol(red, green, blue);
    }

    @Override
    public boolean equals(Object o) {
        // to-do: Write this method.
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        SimpleSymbol that = (SimpleSymbol) o;
        return (this.red == that.red) && (this.green == that.green) && (this.blue == that.blue);
    }

    @Override
    public int hashCode() {
        if (!USE_PERFECT_HASH) {
            return red + green + blue;
        } else {
            // to-do: Write a perfect hash function for SimpleSymbol.
            return red / 5  * 256 * 256 + green / 5 * 256 + blue / 5;
        }
    }

}
