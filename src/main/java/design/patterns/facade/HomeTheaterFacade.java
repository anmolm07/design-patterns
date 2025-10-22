package design.patterns.facade;

class HomeTheaterFacade {
    Amplifier amp;
    DvdPlayer dvd;
    Projector projector;

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, Projector projector) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down home theater...");
        dvd.stop();
        dvd.off();
        amp.off();
        projector.off();
    }
}