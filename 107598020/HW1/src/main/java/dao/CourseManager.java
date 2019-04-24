package dao;

import configuration.DatabaseConfiguration;
import dataBase.SqlLite;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class CourseManager {
    private ArrayList<CourseDao> courses;
    private SqlLite sqlDB;
    private Connection conn;
    private Statement state;


    public CourseManager() {
        try {
            courses= new ArrayList<CourseDao>();
            sqlDB = new SqlLite(new DatabaseConfiguration().getDatabaseProperties());
            getCourseFromDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CourseManager(Properties props) throws IOException, ClassNotFoundException {
        courses= new ArrayList<CourseDao>();
        sqlDB = new SqlLite(props);
        getCourseFromDatabase();
    }

    public ArrayList<CourseDao> getCourseList() {
        return courses;
    }

    public void updateCourse(CourseDao course) {
        courses.clear();
        updateDatabase(course);
        getCourseFromDatabase();
    }

    public void addCourse(CourseDao course) {
        courses.clear();
        addToDataBase(course);
        getCourseFromDatabase();
    }

    public void deleteCourse(CourseDao course) {
        courses.clear();
        deleteCourseFromDatabase(course);
        getCourseFromDatabase();
    }


    private void getCourseFromDatabase() {
        try {
            conn = sqlDB.getConnection();
            state = conn.createStatement();
            transferToDao(state.executeQuery("SELECT  * FROM course;"));
            state.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void transferToDao(ResultSet rs) throws SQLException {
        while (rs.next()) {
            courses.add(generateCourseDAO(rs));
        }
    }

    private CourseDao generateCourseDAO(ResultSet rs) throws SQLException {
        CourseDao course = new CourseDao(rs.getInt("id"));
        course.setName(rs.getString("name"));
        course.setDescription(rs.getString("description"));
        course.setTargetCluster(rs.getString("targetCluster"));
        course.setPrice(rs.getInt("price"));
        course.setCourseNotice(rs.getString("courseNotice"));
        course.setNotes(rs.getString("notes"));
        System.out.println(course);
        return course;
    }

    private void updateDatabase(CourseDao course) {
        try {
            conn = sqlDB.getConnection();
            state = conn.createStatement();
            String updateSql = "Update course  " +
                               "SET name = '" + course.getName() + "', " +
                                   "description = '" + course.getDescription() + "', " +
                                   "targetCluster = '" + course.getTargetCluster() + "', " +
                                   "price = '" + course.getPrice() + "', " +
                                   "courseNotice = '" + course.getCourseNotice() + "', " +
                                   "notes = '" + course.getNotes() + "' " +
                               "WHERE id = " + course.getId();

            System.out.println(updateSql);
            state.execute(updateSql);
            state.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addToDataBase(CourseDao course) {
        try {
            conn = sqlDB.getConnection();
            state = conn.createStatement();
            String insertSql = "INSERT INTO course (name, description, targetCluster, price, courseNotice, notes) " +
                                "VALUES ('" + course.getName() + "', '"
                                            + course.getDescription() + "', '"
                                            + course.getTargetCluster() + "', '"
                                            + course.getPrice() + "', '"
                                            + course.getCourseNotice() + "', '"
                                            + course.getNotes() + "');";

            System.out.println(insertSql);
            state.execute(insertSql);
            state.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteCourseFromDatabase(CourseDao course) {
        try {
            conn = sqlDB.getConnection();
            state = conn.createStatement();
            String deleteSql = "DELETE FROM course WHERE id = " + course.getId();

            System.out.println(deleteSql);
            state.execute(deleteSql);
            state.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
