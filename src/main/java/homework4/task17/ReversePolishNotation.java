package homework4.task17;

import java.util.*;

/**
 * Created by koval on 15.12.2016.
 */
public class ReversePolishNotation {

    public static final String LEFT_SIDE = "(";
    public static final String RIGHT_SIDE = ")";

    public static final String DELIMITER = "\\s+";

    public static final String ILLEGAL_TOKENS = "Invalidated tokens: %s %s";
    public static final String ILLEGAL_TOKEN = "Invalidated token: %s";

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    private static final Map<String, Integer> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put(PLUS, 0);
        OPERATORS.put(MINUS, 0);
        OPERATORS.put(MULTIPLY, 1);
        OPERATORS.put(DIVIDE, 1);
    }

    private static boolean isOperator(final String token) {
        return OPERATORS.containsKey(token);
    }

    private static boolean isAssociative(final String token, final int type) {

        if (!isOperator(token)) {
            throw new IllegalArgumentException(String.format(ILLEGAL_TOKEN, token));
        }

        if (OPERATORS.get(token) == type) {
            return true;
        }

        return false;
    }


    private static int cmpPrecedence(final String token1, final String token2) {

        if (!isOperator(token1) || !isOperator(token2)) {
            throw new IllegalArgumentException(String.format(ILLEGAL_TOKENS, token1, token2));
        }

        return OPERATORS.get(token1) - OPERATORS.get(token2);
    }

    public static String[] toReservePolishNotation(String[] inputTokens) {

        final ArrayList<String> out = new ArrayList<>();
        final Stack<String> stack = new Stack<>();

        for (String token : inputTokens) {

            if (isOperator(token)) {

                while (!stack.empty() && isOperator(stack.peek())) {

                    if ((isAssociative(token, 1) && cmpPrecedence(token, stack.peek()) <= 0)) {
                        out.add(stack.pop());
                        continue;
                    }
                    break;
                }

                stack.push(token);

            } else if (token.equals(LEFT_SIDE)) {
                stack.push(token);
            } else if (token.equals(RIGHT_SIDE)) {

                while (!stack.empty() && !stack.peek().equals(LEFT_SIDE)) {
                    out.add(stack.pop());
                }

                stack.pop();
            } else {
                out.add(token);
            }
        }

        while (!stack.empty()) {
            out.add(stack.pop());
        }

        String[] output = new String[out.size()];

        return out.toArray(output);
    }

    public static String[] splitString(final String string) {
        return string.split(DELIMITER);
    }

    public static Double parsePolishNote(final String[] array) {

        final Stack<Expression> stack = new Stack<>();

        Arrays.stream(array).forEach(element -> {
            switch (element) {
                case PLUS : stack.push(new PlusExpression(stack.pop(), stack.pop())); break;
                case MINUS : stack.push(new MinusExpression(stack.pop(), stack.pop())); break;
                case MULTIPLY : stack.push(new MultiplyExpression(stack.pop(), stack.pop())); break;
                case DIVIDE : stack.push(new DivideExpression(stack.pop(), stack.pop())); break;
                default: stack.push(new NumberExpression(element));
            }
        });

        return stack.pop().interpret();
    }

    public static Double getResult(final String expression) {
        return parsePolishNote(toReservePolishNotation(splitString(expression)));
    }
}
