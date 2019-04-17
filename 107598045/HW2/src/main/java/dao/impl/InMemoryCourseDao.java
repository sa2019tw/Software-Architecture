package dao.impl;

import dao.CourseDao;
import model.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCourseDao implements CourseDao {
    private List<Course> courses;
    private int maxId;

    public InMemoryCourseDao() {
        courses = new ArrayList<>();
        maxId = 0;
    }

    @Override
    public int getMaxCourseId() throws SQLException {
        return maxId;
    }

    @Override
    public List<Course> getCourseList() throws SQLException {
        return courses;
    }

    @Override
    public void insertCourseToDB(Course course) throws SQLException {
        courses.add(course);
        maxId++;
    }

    @Override
    public void deleteCourseToDB(int courseId) throws SQLException {
        courses.forEach(each -> {
            if (each.getCourseId() == courseId)
                courses.remove(each);
        });
    }

    @Override
    public Course findTheCourse(int courseId) throws SQLException {
        for (Course each : courses) {
            if (each.getCourseId() == courseId)
                return each;
        }
        return null;
    }

    @Override
    public void editCourseToDB(Course course) throws SQLException {
        deleteCourseToDB(course.getCourseId());
        insertCourseToDB(course);
    }
}
