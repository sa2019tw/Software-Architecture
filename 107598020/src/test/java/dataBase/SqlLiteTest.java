package dataBase;

import configuration.DatabaseConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class SqlLiteTest {
    private SqlLite sqlDB;
    private DatabaseConfiguration dbConfig;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        Class.forName("org.sqlite.JDBC");
        dbConfig = new DatabaseConfiguration();
        sqlDB = new SqlLite(dbConfig.getTestDatabaseProperties());
    }

    @After
    public void tearDown() throws Exception {
        sqlDB.closeConnection(conn);
    }

    @Test
    public void getConnectionTest() {
        try {
            conn = sqlDB.getConnection();
            assertFalse(conn.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void closeConnectionTest() {
        try {
            conn = sqlDB.getConnection();
            sqlDB.closeConnection(conn);
            assertTrue(conn.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
