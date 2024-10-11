import java.util.HashMap;

public class Configuration {

    private static Configuration instance;
    private static HashMap<String, String> map;

    private Configuration() {
    };

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
            map = new HashMap<>();
        }
        return instance;
    }

    public String getSetting(String key) {
        return map.get(key);
    }

    public void setSetting(String key, String value) {
        map.put(key, value);
    }

}
