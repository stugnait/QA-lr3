package test;

import static org.junit.jupiter.api.Assertions.*;

import converter.IntegerToRomanConverter;
import org.junit.jupiter.api.Test;

public class IntegerToRomanConverterTest {

    @Test
    void test1() { assertEquals("I", IntegerToRomanConverter.intToRoman(1)); }

    @Test
    void test2() { assertEquals("II", IntegerToRomanConverter.intToRoman(2)); }

    @Test
    void test3() { assertEquals("III", IntegerToRomanConverter.intToRoman(3)); }

    @Test
    void test4() { assertEquals("IV", IntegerToRomanConverter.intToRoman(4)); }

    @Test
    void test5() { assertEquals("V", IntegerToRomanConverter.intToRoman(5)); }

    @Test
    void test6() { assertEquals("VI", IntegerToRomanConverter.intToRoman(6)); }

    @Test
    void test7() { assertEquals("IX", IntegerToRomanConverter.intToRoman(9)); }

    @Test
    void test8() { assertEquals("X", IntegerToRomanConverter.intToRoman(10)); }

    @Test
    void test9() { assertEquals("XIV", IntegerToRomanConverter.intToRoman(14)); }

    @Test
    void test10() { assertEquals("XV", IntegerToRomanConverter.intToRoman(15)); }

    @Test
    void test11() { assertEquals("XIX", IntegerToRomanConverter.intToRoman(19)); }

    @Test
    void test12() { assertEquals("XX", IntegerToRomanConverter.intToRoman(20)); }

    @Test
    void test13() { assertEquals("XXIV", IntegerToRomanConverter.intToRoman(24)); }

    @Test
    void test14() { assertEquals("XL", IntegerToRomanConverter.intToRoman(40)); }

    @Test
    void test15() { assertEquals("L", IntegerToRomanConverter.intToRoman(50)); }

    @Test
    void test16() { assertEquals("XC", IntegerToRomanConverter.intToRoman(90)); }

    @Test
    void test17() { assertEquals("C", IntegerToRomanConverter.intToRoman(100)); }

    @Test
    void test18() { assertEquals("CD", IntegerToRomanConverter.intToRoman(400)); }

    @Test
    void test19() { assertEquals("D", IntegerToRomanConverter.intToRoman(500)); }

    @Test
    void test20() { assertEquals("CM", IntegerToRomanConverter.intToRoman(900)); }

    @Test
    void test21() { assertEquals("M", IntegerToRomanConverter.intToRoman(1000)); }

    @Test
    void test22() { assertEquals("MMM", IntegerToRomanConverter.intToRoman(3000)); }

    @Test
    void test23() { assertEquals("MMMCMXCIX", IntegerToRomanConverter.intToRoman(3999)); }

    @Test
    void test24() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> IntegerToRomanConverter.intToRoman(0));
        assertEquals("Input must be between 1 and 3999", exception.getMessage());
    }

    @Test
    void test25() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> IntegerToRomanConverter.intToRoman(4000));
        assertEquals("Input must be between 1 and 3999", exception.getMessage());
    }
}
