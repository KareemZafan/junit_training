package org.iti.mobile;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.platform.commons.util.StringUtils;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Execution(ExecutionMode.CONCURRENT)
public class CalculatorTests {

    private Calculator calculator;

    @BeforeAll
    static void setUp() {
        System.out.println("Before all tests");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("After all tests ");
    }

    static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

    @BeforeEach
    void openDatabase() {
        System.out.println("This will run before each test");
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testAdd(String input1, String input2, String result) {
        assertEquals(Double.parseDouble(result), calculator.add(Double.parseDouble(input1), Double.parseDouble(input2)));

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testSub() {
        assertEquals(0, calculator.sub(10, 10));
        assertEquals(-9, calculator.sub(1, 10));
    }

    @Test
    @DisplayName("test the multiplication of two numbers")
    @Tag("Feb")
    void testMul() {
        assertEquals(100, calculator.mul(10, 10));
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @Tag("Feb")
    void testDiv() {
        assertEquals(1, calculator.div(10, 10));
        var exception = Assertions.assertThrowsExactly(ArithmeticException.class, () -> calculator.div(1, 0));
        assertEquals("Dividing By Zero", exception.getMessage());

    }

    @RepeatedTest(value = 5)
    void testMod() {
        assertEquals(1, calculator.mod(1, 10));
    }

    @Test
    @Tag("Feb")
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void testConversionToUpperCase() {
        String text = "Hello Together".toUpperCase();
        assertEquals("HELLO TOGETHER", text);

    }

    @ParameterizedTest
    @ValueSource(doubles = {70, 80, 10, 100})
    void testNumberLargeThan50(double input) {
        Assertions.assertTrue(input > 50);
    }

    @ParameterizedTest
    @CsvSource({"-10,60,50", "1,3,4"})
    void testAdd2(String input1, String input2, String result) {
        assertEquals(Double.parseDouble(result), calculator.add(Double.parseDouble(input1), Double.parseDouble(input2)));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, StringUtils.isBlank(input));
    }

}
