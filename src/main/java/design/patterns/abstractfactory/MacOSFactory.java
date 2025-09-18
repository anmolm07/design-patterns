package design.patterns.abstractfactory;

import design.patterns.abstractfactory.button.Button;
import design.patterns.abstractfactory.button.MacOSButton;
import design.patterns.abstractfactory.checkbox.Checkbox;
import design.patterns.abstractfactory.checkbox.MacOSCheckbox;

class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}