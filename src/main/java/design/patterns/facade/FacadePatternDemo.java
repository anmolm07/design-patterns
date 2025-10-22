package design.patterns.facade;

public class FacadePatternDemo {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}