package database;

import java.util.Properties;

public class SqlLiteConfiguration {
    private Properties database;
    private String currentPath;

    public SqlLiteConfiguration() {
        this.database = new Properties();
        this.currentPath = System.getProperty("user.dir");
    }



    public Properties getDatabaseProperties() {
        database.put("url", "jdbc:sqlite:" + currentPath + "\\course.db");
        database.put("user", "root");
        database.put("password", "password");
        return database;
    }

    public Properties getTestDatabaseProperties() {
        database.put("url", "jdbc:sqlite:" + currentPath + "\\test.db");
        database.put("user", "root");
        database.put("password", "password");
        return database;
    }

}
