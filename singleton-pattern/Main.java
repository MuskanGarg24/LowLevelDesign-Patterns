public class Main {

    public static void main(String[] var0) {

        Configuration configuration = Configuration.getInstance();
        configuration.setSetting("Theme", "Dark");
        System.out.println(configuration.getSetting("Theme"));

        Configuration anotheConfiguration = Configuration.getInstance();
        anotheConfiguration.setSetting("Theme2", "Light");
        System.out.println(anotheConfiguration.getSetting("Theme2"));

        System.out.println("Are both instances same? " + (configuration == anotheConfiguration));
    }
}
