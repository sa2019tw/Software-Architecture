package mock;

import entity.Course;
import entity.dao.ICourseDao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MockCourseDao implements ICourseDao {
    private List<Course> allCourses;

    public MockCourseDao(List<Course> courses) {
        allCourses = courses;
    }

    @Override
    public int addCourse(Course course) {
        if (course.getTitle() == null)
            return 0;
        return course.getTitle().isEmpty() ? 0 : 1;
    }

    @Override
    public int updateCourse(Course course) {
        long result = allCourses.stream().filter(each -> each.getId().equals(course.getId())).count();
        return Math.toIntExact(result);
    }

    @Override
    public int deleteCourse(int id) {
        long result = allCourses.stream().filter(each -> each.getId().equals(id)).count();
        return Math.toIntExact(result);
    }

    @Override
    public List<Course> getAllCourses() {
        return allCourses;
    }

    @Override
    public Optional<Course> getCourseById(int id) {
        return id > allCourses.size() ? Optional.empty() : Optional.of(allCourses.get(id));
    }


}
