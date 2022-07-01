package code.elif;

import javafx.scene.control.TextField;

public class TextBox extends TextField implements UIControl {

    UIMediator uiMediator;
    boolean mediatedUpdate;

    public TextBox(UIMediator uiMediator) {
        this.uiMediator = uiMediator;
        this.setText("TextBox");
        this.uiMediator.register(this);

        this.textFormatterProperty().addListener((v, o, n) -> {
            if (!mediatedUpdate) this.uiMediator.valueChanged(this);
        });
    }

    @Override
    public void controlChanged(UIControl control) {
        this.mediatedUpdate = true;
        this.setText(control.getControlValue());
        this.mediatedUpdate = false;
    }

    @Override
    public String getControlValue() {
        return getText();
    }

    @Override
    public String getControlName() {
        return "TextBox";
    }
}
