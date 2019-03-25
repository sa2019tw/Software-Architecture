package presenter;

import entity.Course;
import service.CourseService;
import view.ObservableCourse;

import java.util.List;
import java.util.stream.Collectors;

public class CoursePresenter {
    private CourseService courseService;

    public CoursePresenter() {
        courseService = new CourseService();
    }

    public List<ObservableCourse> getAllCourses() {
        return courseService.getAllCourses().stream()
                .map(ObservableCourse::new)
                .collect(Collectors.toList());
    }

    public void addCourse(ObservableCourse course) {
        courseService.addCourse(convertToCourse(course));
    }

    public void editCourse(ObservableCourse course) {
        courseService.updateCourse(convertToCourse(course));
    }

    public void deleteCourse(int id) {
        courseService.deleteCourse(id);
    }

    private Course convertToCourse(ObservableCourse observableCourse) {
        Course course = new Course();
        course.setId(observableCourse.getId() == null ? null : Integer.valueOf(observableCourse.getId()));
        course.setTitle(observableCourse.getTitle());
        course.setDescription(observableCourse.getDescription());
        course.setSuitablePeople(observableCourse.getSuitablePeople());
        course.setPrice(observableCourse.getPrice() == null ? null : Integer.valueOf(observableCourse.getPrice()));
        course.setAnnouncement(observableCourse.getAnnouncement());
        course.setRemark(observableCourse.getRemark());
        return course;
    }
}
