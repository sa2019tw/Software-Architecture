package dao;

import dataBase.SqlLite;
import configuration.DatabaseConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseManagerTest {
    private CourseManager courseManager;
    private SqlLite sqlDB;
    private Connection conn;
    private Statement state;
    private List<CourseDao> test;

    @Before
    public void setUp() throws Exception {
        Class.forName("org.sqlite.JDBC");
        sqlDB = new SqlLite(new DatabaseConfiguration().getTestDatabaseProperties());
        conn = sqlDB.getConnection();
        state = conn.createStatement();
        createTable();
        addDataToTable();

        courseManager = new CourseManager(new DatabaseConfiguration().getTestDatabaseProperties());

        String sql = "SELECT * FROM course;";
        ResultSet rs = state.executeQuery(sql);
        test = new ArrayList<CourseDao>();
        test.add(new CourseDao(1, "SA"));
        test.add(new CourseDao(2, "abc"));
        test.add(new CourseDao(3, "def"));
        rs.close();
        state.close();
        sqlDB.closeConnection(conn);
    }

    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS course(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT DEFAULT ''," +
                "description TEXT DEFAULT ''," +
                "targetCluster TEXT DEFAULT ''," +
                "price int DEFAULT 0," +
                "courseNotice TEXT DEFAULT ''," +
                "notes TEXT DEFAULT '');";
        state.execute(sql);
    }

    private void addDataToTable() throws SQLException {
        String sql1 = "INSERT INTO course (name) VALUES (\"SA\") ";
        String sql2 = "INSERT INTO course (name) VALUES (\"abc\") ";
        String sql3 = "INSERT INTO course (name) VALUES (\"def\") ";
        state.execute(sql1);
        state.execute(sql2);
        state.execute(sql3);
    }

    @After
    public void tearDown() throws Exception {
        dropTable();
    }

    private void dropTable() {
        String sql = "DROP table IF EXISTS 'course';";
        try {
            conn = sqlDB.getConnection();
            state = conn.createStatement();
            state.execute(sql);
            state.close();
            sqlDB.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCourseListTest() {
        List<CourseDao> database = courseManager.getCourseList();
        for (int i = 0; i < 3; i ++ ) {
            assertTrue(test.get(i).equals(database.get(i)));
        }
    }

    @Test
    public void updateCourseTest() {
        test.get(1).setPrice(200);
        courseManager.updateCourse(test.get(1));

        List<CourseDao> database = courseManager.getCourseList();
        assertTrue(test.get(1).equals(database.get(1)));
    }

    @Test
    public void addCourse() {
        CourseDao dao = new CourseDao(4, "ssss");
        test.add(dao);
        courseManager.addCourse(dao);
        List<CourseDao> database = courseManager.getCourseList();
        assertTrue(test.get(3).equals(database.get(3)));
    }

    @Test
    public void deleteCourse() {
        List<CourseDao> database = courseManager.getCourseList();
        assertEquals(3, database.size());

        CourseDao course = test.remove(2);
        courseManager.deleteCourse(course);
        database = courseManager.getCourseList();

        assertEquals(2, database.size());
    }
}