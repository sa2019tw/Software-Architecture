package dbcon;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class DBCon {
    private static String dbClass = "com.mysql.jdbc.Driver";
    private static String dbSource = "jdbc:mysql://127.0.0.1:3306";
    private static String db = "jdbc:mysql://127.0.0.1:3306/";
    private static String user = "root";
    private static String passwd = "a159327";

    public final static String Course = "course";

    public static Connection getConnection(String dbName) throws Exception {
        Class.forName(dbClass);
        try {
            String url = db + dbName + "?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(url, user, passwd);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeAll(Connection conn,Statement stmt,ResultSet rs) throws SQLException {
        if(rs!=null)
            rs.close();
        if(stmt!=null)
            stmt.close();
        if(conn!=null)
            conn.close();
    }










}
