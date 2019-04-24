import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PluginFactory {

    public static Object getPlugin(Class iface) {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String className = properties.getProperty(iface.getName());

        try {
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
