package code.elif.app.features.java16.sealed;

public record Constant(double value) implements Expression {
    @Override
    public double evaluate() {
        return value;
    }
}
