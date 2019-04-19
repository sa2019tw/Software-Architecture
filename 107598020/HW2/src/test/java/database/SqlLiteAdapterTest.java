package database;

import entity.Course;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usecase.CourseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class SqlLiteAdapterTest {
    private CourseDao sqlDB;
    private Course course;
    private String url;

    @Before
    public void setUp() throws Exception {
        Class.forName("org.sqlite.JDBC");
        SqlLiteConfiguration dbConfig = new SqlLiteConfiguration();
        sqlDB = new SqlLiteAdapter(dbConfig.getTestDatabaseProperties());
        course = new Course("abc");

        url = dbConfig.getTestDatabaseProperties().getProperty("url");
        createTable(url);
    }

    private void createTable(String url) throws SQLException {
        Connection conn = DriverManager.getConnection(url);
        Statement state = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS course(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT DEFAULT ''," +
                "description TEXT DEFAULT ''," +
                "targetCluster TEXT DEFAULT ''," +
                "price int DEFAULT 0," +
                "courseNotice TEXT DEFAULT ''," +
                "notes TEXT DEFAULT '');";
        state.execute(sql);
        state.close();
        conn.close();
    }

    @After
    public void tearDown() {
        dropTable();
    }

    private void dropTable() {
        String sql = "DROP table IF EXISTS 'course';";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement state = conn.createStatement();
            state.execute(sql);
            state.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createCourseTest() {
        try {
            sqlDB.createCourse(course);
            assertEquals(1, sqlDB.getAllCourses().size());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getAllCoursesTest() {
        try {
            assertEquals(0, sqlDB.getAllCourses().size());
            createCourseTest();
            assertEquals(1, sqlDB.getAllCourses().size());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void modifyCourseTest() {
        try {
            createCourseTest();

            List<Course> courses = sqlDB.getAllCourses();
            assertEquals(0, courses.get(0).getPrice());


            courses.get(0).setPrice(200000);
            sqlDB.modifyCourse(courses.get(0));

            courses = sqlDB.getAllCourses();
            assertEquals(200000, courses.get(0).getPrice());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void deleteCourseTest() {
        try {
            assertEquals(0, sqlDB.getAllCourses().size());

            createCourseTest();
            assertEquals(1, sqlDB.getAllCourses().size());

            sqlDB.deleteCourse(sqlDB.getAllCourses().get(0));
            assertEquals(0, sqlDB.getAllCourses().size());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}