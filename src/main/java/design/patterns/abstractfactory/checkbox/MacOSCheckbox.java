package design.patterns.abstractfactory.checkbox;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a macOS Checkbox.");
    }
}