package homework4.task17;

/**
 * Created by koval on 18.12.2016.
 */
public class NumberExpression implements Expression {

    private final double number;

    public NumberExpression(double number) {
        this.number = number;
    }

    public NumberExpression(String value) {
        number = Double.parseDouble(value);
    }

    @Override
    public double interpret() {
        return number;
    }
}
