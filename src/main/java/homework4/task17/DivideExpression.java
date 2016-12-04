package homework4.task17;

/**
 * Created by koval on 04.12.2016.
 */
public class DivideExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public DivideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret() {
        return left.interpret() / right.interpret();
    }
}
