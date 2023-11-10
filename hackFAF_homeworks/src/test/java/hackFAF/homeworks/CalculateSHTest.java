package hackFAF.homeworks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateSHTest {

    //T1 e T3
    @DisplayName("Sad Path Tests")
    @Test
    public void nullOrEmptyArray() {
        int[] nullArray = null;
        int[] emptyArray = {};

        assertThrows(IllegalArgumentException.class, () -> CalculateSH.calculateSumOfEvenNumbers(nullArray));
        assertThrows(IllegalArgumentException.class, () -> CalculateSH.calculateSumOfEvenNumbers(emptyArray));
    }



    @ParameterizedTest
    @DisplayName("Happy Path Tests")
    @MethodSource("happyPathTestCases")
    public void valuesHappyPath(int[] numbers, int excepted){

        assertEquals(excepted, CalculateSH.calculateSumOfEvenNumbers(numbers));
    }

    public static Stream<Arguments> happyPathTestCases() {
        return Stream.of(
                Arguments.of(new int[]{18,20,88}, 100), //T2

                //single element array
                Arguments.of(new int[]{12},24),//T4
                Arguments.of(new int[]{3},0), //T5
                Arguments.of(new int[]{-30},0), //T6
                Arguments.of(new int[]{-73},0), //T7
                Arguments.of(new int[]{0},0), //T8

                //combination of inputs
                Arguments.of(new int[]{2, 3, 4, 5},6), //T9
                Arguments.of(new int[]{2, 4, -4, -2},6), //T10
                Arguments.of(new int[]{1, 3, -3, -1},0), //T11
                Arguments.of(new int[]{2, 0, 4, 18},42), //T12
                Arguments.of(new int[]{1, 0, 3, 17},0), //T13
                Arguments.of(new int[]{-1, 0,-3, -10},0), //T14

                //boundary test
                Arguments.of(new int[]{1},0), //T15
                Arguments.of(new int[]{2},2) //T16
        );
    }

}
