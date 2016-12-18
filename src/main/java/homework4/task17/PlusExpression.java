package homework4.task17;

/**
 * Created by koval on 18.12.2016.
 */
public class PlusExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret() {
        return left.interpret() + right.interpret();
    }
}
