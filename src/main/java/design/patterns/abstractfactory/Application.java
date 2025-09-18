package design.patterns.abstractfactory;

import design.patterns.abstractfactory.button.Button;
import design.patterns.abstractfactory.checkbox.Checkbox;

public class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        GUIFactory factory;
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("windows")) {
            factory = new WindowsFactory();
        } else { // Assuming macOS for simplicity if not Windows
            factory = new MacOSFactory();
        }

        Application app = new Application(factory);
        app.paint();
    }
}