package symbol;

import java.util.List;

/**
 * Created by Jolly on 4/9/17.
 */
public class SymbolTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Symbol> symbols, int M) {
        /* to-do: Write a utility function that returns true if the given symbols
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each SimpleSymbol's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * SimpleSymbols and no bucket has more than N / 2.5 SimpleSymbols.
         */
        int bucketNum;
        int[] bucketPos = new int[M];
        for (Symbol s : symbols) {
            bucketNum = (s.hashCode() & 0x7FFFFFFF) % M;
            bucketPos[bucketNum]++;
        }
        for (int i = 0; i < M; i++) {
            if (bucketPos[i] < symbols.size() / 50 || bucketPos[i] > symbols.size() / 2.5) {
                return false;
            }
        }
        return true;
    }
}
