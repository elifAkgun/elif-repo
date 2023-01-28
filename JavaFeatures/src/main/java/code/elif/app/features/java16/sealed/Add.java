package code.elif.app.features.java16.sealed;

public record Add(Expression left, Expression right) implements Expression {
    @Override
    public double evaluate() {
        return left.evaluate() + right().evaluate();
    }
}
