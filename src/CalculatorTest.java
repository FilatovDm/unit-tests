import org.assertj.core.api.Assertions;
import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public CalculatorTest() {
    }

    public static void main(String[] args) {
        Assertions.assertThat(Calculator.calculatingDiscount(100.0, 5)).isEqualTo(95.0);
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculatingDiscount(0.0, 5);
        }).isInstanceOf(ArithmeticException.class);
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculatingDiscount(-100.0, 5);
        }).isInstanceOf(ArithmeticException.class);
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculatingDiscount(100.0, -1);
        }).isInstanceOf(ArithmeticException.class);
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculatingDiscount(100.0, 0);
        }).isInstanceOf(ArithmeticException.class);
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculatingDiscount(100.0, 100);
        }).isInstanceOf(ArithmeticException.class);
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculatingDiscount(100.0, 101);
        }).isInstanceOf(ArithmeticException.class);
    }
}