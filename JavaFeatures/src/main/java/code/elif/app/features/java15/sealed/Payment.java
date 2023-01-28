package code.elif.app.features.java15.sealed;

public sealed abstract class Payment permits CardPayment, CashPayment {

}
