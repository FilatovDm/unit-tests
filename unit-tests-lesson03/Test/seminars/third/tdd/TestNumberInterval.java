package seminars.third.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNumberInterval {
    /**
     * тесты для задачи 3 (проверить вхождение числа в интервал (25;100) )
     */

    @ParameterizedTest(name = "number in interval ={0}")
    @ValueSource(ints = {26, 50, 99})
    void NumberInInterval(int number) {
        assertTrue(NumberInterval.numberInInterval(number));
    }

    @ParameterizedTest(name = "number out interval ={0}")
    @ValueSource(ints = {0, 25, 100, 1000})
    void NumberOutInterval(int number) {
        assertFalse(NumberInterval.numberInInterval(number));
    }

}