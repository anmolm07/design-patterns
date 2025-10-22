package design.patterns.facade;

class Projector {
    public void on() {
        System.out.println("Projector On");
    }

    public void wideScreenMode() {
        System.out.println("Projector in widescreen mode");
    }

    public void off() {
        System.out.println("Projector Off");
    }
}