package symbol;

/**
 * Created by Jolly on 4/9/17.
 */
public class SimpleSymbol {
    protected int red;
    protected int green;
    protected int blue;

    private static final double WIDTH = 0.01;
    private static final boolean USE_PERFECT_HASH = false;

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
}