package design.patterns.abstractfactory;

import design.patterns.abstractfactory.button.Button;
import design.patterns.abstractfactory.checkbox.Checkbox;

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}