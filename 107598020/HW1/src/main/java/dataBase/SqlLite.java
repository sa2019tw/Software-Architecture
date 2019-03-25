package dataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlLite {
    private String url;
    private String user;
    private String passwd;

    public SqlLite(Properties prop) throws IOException, ClassNotFoundException {
        url = prop.getProperty("url");
        user = prop.getProperty("user");
        passwd = prop.getProperty("password");
    }

    public Connection getConnection() throws SQLException {
        System.out.println("Connect database...");
        return DriverManager.getConnection(url, user, passwd);
    }

    public void closeConnection(Connection conn) throws SQLException {
        System.out.println("Disconnect database...");
        conn.close();
    }
}
