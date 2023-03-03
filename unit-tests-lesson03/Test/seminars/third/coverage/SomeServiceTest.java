package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SomeServiceTest {
    private SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }


//    @Test
//    void testReturnFizz() {
//        assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz");
//    }
//
//    @Test
//    void testReturnBuzz() {
//        assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz");
//    }
//
//    @Test
//    void testReturnFizzBuzz() {
//        assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz");
//    }
//
//    @Test
//    void testReturnEcho() {
//        assertThat(someService.fizzBuzz(14)).isEqualTo("14");
//    }
//
//    @Test
//    void firstSixElement() {
//        assertTrue(someService.firstLast6(new int[]{6, 2, 3}));
//    }
//    @Test
//    void lastSixElement() {
//        assertTrue(someService.firstLast6(new int[]{3, 2, 3, 6}));
//    }
//
//    @Test
//    void firstLastNoSixElement() {
//        assertFalse(someService.firstLast6(new int[]{4, 2, 3}));
//    }
//
//    @Test
//    void luckySumA()
//    {
//        assertThat(someService.luckySum(13,2,3)).isEqualTo(5);
//    }
//
//    @Test
//    void luckySumB()
//    {
//        assertThat(someService.luckySum(1,13,3)).isEqualTo(4);
//    }
//
//    @Test
//    void luckySumC()
//    {
//        assertThat(someService.luckySum(1,2,13)).isEqualTo(3);
//    }
//
//    @Test
//    void luckySumNot13()
//    {
//        assertThat(someService.luckySum(1,2,3)).isEqualTo(6);
//    }

    /**
     * @param discount - размер скидки
     * @param result  - итоговая сумма с учетом скидки, которая должна получится после расчета
     */

    @ParameterizedTest(name = "DiscountAmount = {0}%")
    @CsvSource(value = {"0, 2000", "50, 1000", "100, 0"})
    void testDiscountAmountNormal(int discount, int result) {
        assertThat(someService.calculatingDiscount(2000.0, discount))
                .isEqualTo(result); // обычная скидка
    }

    @Test
    void testNegativePurchaseAmount() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(-2000.0, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной"); // процент скидки больше 100%
    }

    @ParameterizedTest(name = "Discount Amount = {0}")
    @ValueSource(ints = {110, -10})
    void testNegativeDiscountAmount(int discount) {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, discount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }


}