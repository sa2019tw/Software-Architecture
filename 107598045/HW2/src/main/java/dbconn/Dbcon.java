package dbconn;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;

public class Dbcon {
    public final static String SACMS = "sacms";
    private final static String userName = "root";
    private final static String password = "password";

    public static Connection getConnection(String dbName) {
        return getConnection(dbName, userName, password);
    }

    public static Connection getConnection(String dbName, String userName, String password) {
        try {
            String url = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(url, userName, password);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
