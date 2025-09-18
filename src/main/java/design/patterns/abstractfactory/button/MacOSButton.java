package design.patterns.abstractfactory.button;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a macOS Button.");
    }
}