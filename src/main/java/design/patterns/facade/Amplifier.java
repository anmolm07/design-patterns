package design.patterns.facade;

class Amplifier {
    public void on() {
        System.out.println("Amplifier On");
    }

    public void setDvd(DvdPlayer dvd) {
        System.out.println("Amplifier setting DVD player : " + dvd);
    }

    public void setVolume(int volume) {
        System.out.println("Amplifier volume set to " + volume);
    }

    public void off() {
        System.out.println("Amplifier Off");
    }
}