package configuration;

import java.util.Properties;

public class DatabaseConfiguration {
    private Properties database;

    public DatabaseConfiguration() {
        this.database = new Properties();
    }

    public Properties getDatabaseProperties() {
        database.put("url", "jdbc:sqlite:D:\\GitLab_CSIE\\SoftwareAchitecture\\course.db");
        database.put("user", "root");
        database.put("password", "password");
        return database;
    }

    public Properties getTestDatabaseProperties() {
        database.put("url", "jdbc:sqlite:D:\\GitLab_CSIE\\SoftwareAchitecture\\test.db");
        database.put("user", "root");
        database.put("password", "password");
        return database;
    }

}
