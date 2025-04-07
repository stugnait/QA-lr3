package converter;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerConverter {

    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Empty or null string is not a valid Roman numeral");
        }

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            Integer currValue = romanMap.get(ch);
            if (currValue == null) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + ch);
            }

            if (currValue < prev) {
                total -= currValue;
            } else {
                total += currValue;
            }
            prev = currValue;
        }

        // Validate correctness
        String reconstructed = IntegerToRomanConverter.intToRoman(total);
        if (!reconstructed.equals(s)) {
            throw new IllegalArgumentException("Invalid Roman numeral sequence: " + s);
        }

        return total;
    }
}
