package code.elif.app.features.java16.sealed;

public sealed interface Expression permits Add, Constant, Multiply {
    double evaluate();
}
