package usecase.testObject;

import entity.Course;
import usecase.CourseDao;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements CourseDao {
    private ArrayList<Course> courses = new ArrayList<Course>();
    private int id = 2;
    public InMemoryDatabase() {
        courses.add(new Course(0));
        courses.add(new Course(1));
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public void deleteCourse(Course course) {
        for(Course c : courses) {
            if (c.getId() == course.getId()) {
                courses.remove(c);
                break;
            }
        }
    }

    public void modifyCourse(Course course) {
        for(Course c : courses) {
            if (c.getId() == course.getId()) {
                courses.remove(c);
                courses.add(course);
                break;
            }
        }
    }

    public void createCourse(Course course) {
        courses.add(new Course(id,
                            course.getName(),
                            course.getDescription(),
                            course.getTargetCluster(),
                            course.getPrice(),
                            course.getCourseNotice(),
                            course.getNotes()));
        id++;
    }

}
