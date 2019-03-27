package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnector {

    public Connection connection;
    private String dbName = "course_management";
    private String username = "root";
    private String password = "root";

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/" + dbName, username, password);
        } catch (Exception e){
            System.out.println("SQLException: " + e.getMessage());
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
