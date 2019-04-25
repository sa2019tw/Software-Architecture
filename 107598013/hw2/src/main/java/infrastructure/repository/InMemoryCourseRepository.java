package infrastructure.repository;

import core.boundary.require.ICourseRepository;
import core.entity.Course;
import core.entity.UnhandleException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryCourseRepository implements ICourseRepository {
    private List<Course> courses;
    private int id;

    public InMemoryCourseRepository() {
        this.id = 0;
        this.courses = new ArrayList<>();
    }

    @Override
    public int addCourse(Course course) {
        if (course.getTitle() == null)
            throw new UnhandleException("The courses's title should not be null");
        if (!course.getTitle().isEmpty()) {
            Course.Builder builder = toCourseBuilder(course);
            builder.id(++id);
            courses.add(builder.build());
            return id;
        }
        return -1;
    }

    @Override
    public int updateCourse(Course course) {
        if (course.getTitle() == null)
            throw new UnhandleException("The courses's title should not be null");

        List<Course> result = courses.stream()
                .filter(each -> each.getId().equals(course.getId()))
                .collect(Collectors.toList());
        if (result.size() == 1) {
            courses.remove(result.get(0));
            courses.add(course);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteCourse(int id) {
        List<Course> result = courses.stream()
                .filter(each -> each.getId().equals(id))
                .collect(Collectors.toList());
        if (result.size() == 1) {
            courses.remove(result.get(0));
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteCourse(Course course) {
        List<Course> result = courses.stream()
                .filter(each -> each.getId().equals(course.getId()))
                .collect(Collectors.toList());
        if (result.size() == 1) {
            courses.remove(result.get(0));
            return 1;
        }
        return 0;
    }

    @Override
    public List<Course> getAllCourse() {
        return courses;
    }

    @Override
    public Optional<Course> getCourseById(int id) {
        return id > courses.size() ? Optional.empty() : Optional.of(courses.get(id));
    }

    private Course.Builder toCourseBuilder(Course course) {
        return new Course.Builder(course.getTitle())
                .id(course.getId())
                .description(course.getDescription())
                .suitablePeople(course.getSuitablePeople())
                .price(course.getPrice())
                .announcement(course.getAnnouncement())
                .remark(course.getRemark());
    }
}
