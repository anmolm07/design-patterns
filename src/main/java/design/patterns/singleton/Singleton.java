package design.patterns.singleton;

public class Singleton {

    private Singleton(){}

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static synchronized Singleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
