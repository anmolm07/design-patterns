package design.patterns.abstractfactory;

import design.patterns.abstractfactory.button.Button;
import design.patterns.abstractfactory.button.WindowsButton;
import design.patterns.abstractfactory.checkbox.Checkbox;
import design.patterns.abstractfactory.checkbox.WindowsCheckbox;

class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}