package homework4.task17;

import java.util.Arrays;
import java.util.Stack;

import static homework4.task17.Evaluate.Operators.*;

/**
 * Created by koval on 04.12.2016.
 */
public class Evaluate {

    private static final Evaluate instance = new Evaluate();

    public static Evaluate getInstance() {
        return instance;
    }

    private final Stack<Expression> numbers = new Stack<>();

    public double evaluate(final String string) {

        for (int i = 0; i < string.length(); i++) {
            int j = i + 1;
            if (string.charAt(j) == Braces.LEFT) {
                for ( ; j < string.indexOf(Braces.RIGHT, i + 1); j++) {
                    final char value = string.charAt(j);
                    if (isOperator(value)) {
                        final Expression right = numbers.pop();
                        final Expression left = new NumberExpression(string.charAt(j + 1) - 48);
                        final Expression operator = getOperatorInstance(value, left, right);
                        final double result = operator.interpret();
                        numbers.push(new NumberExpression(result));
                        j++;
                    } else {
                        final Expression expression = new NumberExpression(value - 48);
                        numbers.push(expression);
                    }
                }
            }
        }

        return numbers.pop().interpret();
    }

    private boolean isOperator(final char value) {
        return value == PLUS || value == MINUS || value == MULTIPLE || value == DIVIDE;
    }

    private Expression getOperatorInstance(final char value, final Expression left, final Expression right) {
        switch (value) {
            case PLUS:
                return new PlusExpression(left, right);
            case MINUS:
                return new MinusExpression(left, right);
            case MULTIPLE:
                return new MultiplyExpression(left, right);
            case DIVIDE :
                return new DivideExpression(left, right);
            default:
                throw new IllegalArgumentException();
        }
    }

    interface Operators {
        char PLUS = '+';
        char MINUS = '-';
        char MULTIPLE = '*';
        char DIVIDE = '/';
    }

    interface Braces {
        char LEFT = '(';
        char RIGHT = ')';
    }
}
