package seminars.third.coverage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestCheckNumber {
    /**
     * тесты для задачи 2: проверить число на четность. Считаем, что 0 - четное число.
     * @param number - проверяемое число
     */

    @ParameterizedTest(name = "number = {0}")
    @ValueSource(ints = {0, 2})
    void testEvenNumber(int number){
        assertTrue(CheckNumber.evenOddNumber(number));
    }

    @Test
    void testOddNumber(){
        assertFalse(CheckNumber.evenOddNumber(3));
    }

}
