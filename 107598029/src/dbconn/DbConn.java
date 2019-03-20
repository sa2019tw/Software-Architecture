package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;

public class DbConn {
    public final static String  SA = "sa";
    public final static String SA_CACHE = "sa_cache";

    public static Connection getConnection(String dbName) {
        return getConnection(dbName, "", "");
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
