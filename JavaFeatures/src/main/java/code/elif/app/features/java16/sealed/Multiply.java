package code.elif.app.features.java16.sealed;

public record Multiply(Expression e1, Expression e2) implements Expression {
    @Override
    public double evaluate() {
        return e1.evaluate() * e2.evaluate();
    }
}
