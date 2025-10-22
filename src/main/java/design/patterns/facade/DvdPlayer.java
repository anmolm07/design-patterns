package design.patterns.facade;

class DvdPlayer {
    public void on() {
        System.out.println("DVD Player On");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("DVD Player Stop");
    }

    public void off() {
        System.out.println("DVD Player Off");
    }
}