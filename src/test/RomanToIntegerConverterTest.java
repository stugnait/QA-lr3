package test;

import converter.RomanToIntegerConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RomanToIntegerConverterTest {

    @Test
    void testEmptyString() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt(""));
        assertEquals("Empty or null string is not a valid Roman numeral", e.getMessage());
    }

    @Test
    void testNullInput() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt(null));
        assertEquals("Empty or null string is not a valid Roman numeral", e.getMessage());
    }

    @Test
    void testInvalidSymbolZ() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("Z"));
        assertEquals("Invalid Roman numeral character: Z", e.getMessage());
    }

    @Test
    void testInvalidSequenceIIII() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("IIII"));
        assertEquals("Invalid Roman numeral sequence: IIII", e.getMessage());
    }

    @Test
    void testInvalidSequenceVV() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("VV"));
        assertEquals("Invalid Roman numeral sequence: VV", e.getMessage());
    }

    @Test
    void testInvalidSequenceLL() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("LL"));
        assertEquals("Invalid Roman numeral sequence: LL", e.getMessage());
    }

    @Test
    void testInvalidCombinationIIV() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("IIV"));
        assertEquals("Invalid Roman numeral sequence: IIV", e.getMessage());
    }

    @Test
    void testInvalidSubtractiveLC() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("LC"));
        assertEquals("Invalid Roman numeral sequence: LC", e.getMessage());
    }

    @Test
    void testInvalidMixedLowerUpper() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("MxC"));
        assertEquals("Invalid Roman numeral character: x", e.getMessage());
    }

    @Test
    void testInvalidEmbeddedSymbol() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("MXZ"));
        assertEquals("Invalid Roman numeral character: Z", e.getMessage());
    }
    @Test
    void testValidSimpleNumeral() {
        assertEquals(5, RomanToIntegerConverter.romanToInt("V"));
    }

    @Test
    void testValidComplexNumeral() {
        assertEquals(1987, RomanToIntegerConverter.romanToInt("MCMLXXXVII"));
    }

    @Test
    void testValidLowerBoundary() {
        assertEquals(1, RomanToIntegerConverter.romanToInt("I"));
    }

    @Test
    void testValidUpperBoundary() {
        assertEquals(3999, RomanToIntegerConverter.romanToInt("MMMCMXCIX"));
    }

    @Test
    void testValidWithSubtractiveNotation() {
        assertEquals(4, RomanToIntegerConverter.romanToInt("IV"));
    }

    @Test
    void testValidWithMultipleSubtractiveNotations() {
        assertEquals(944, RomanToIntegerConverter.romanToInt("CMXLIV"));
    }

    @Test
    void testLowercaseInput() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("xiv"));
        assertTrue(e.getMessage().contains("Invalid Roman numeral character"));
    }


    @Test
    void testConsecutiveSubtractivePairs() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("IIVX"));
        assertEquals("Invalid Roman numeral sequence: IIVX", e.getMessage());
    }

    @Test
    void testEmptySpaces() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt(" X "));
        assertEquals("Invalid Roman numeral character:  ", e.getMessage());
    }

    @Test
    void testNonRomanCharacters() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> RomanToIntegerConverter.romanToInt("X2I"));
        assertEquals("Invalid Roman numeral character: 2", e.getMessage());
    }

}
