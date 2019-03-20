package dao;

import model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDaoInterface {
    List<Course> readallcourse() throws SQLException;
    Course getcourseinfo(Integer id) throws SQLException;
    void creatcourse(Course course) throws SQLException;
    void updatecourse(Course course) throws SQLException;
    void deletecourse(Integer id) throws SQLException;
    List<Course> findcourse(String cname) throws SQLException;
}