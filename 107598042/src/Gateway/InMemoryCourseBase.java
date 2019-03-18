package Gateway;

import Domain.Course;
import Domain.CourseBase;

import java.util.*;

public class InMemoryCourseBase implements CourseBase {

    Hashtable<Integer, Course> hashCourse = new Hashtable<Integer, Course>();
    int index = 0;
    @Override
    public ArrayList<Course> fetchAllCourse() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        Set<Integer> keys = hashCourse.keySet();
        ArrayList list = new ArrayList(keys);

        for(Integer key: keys) {
            courseList.add(hashCourse.get(key));
        }

        Collections.sort(courseList, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getId() - o2.getId();
            }
        });

        return courseList;
    }

    @Override
    public void createNewCourse(Course course) {
        course.setId(index);
        hashCourse.put(index, course);
        index++;
    }

    @Override
    public Course fetchCourseById(int id) {
        return hashCourse.get(id);
    }

    @Override
    public void deleteCourseById(int id) {
        hashCourse.remove(new Integer(id));
    }

    @Override
    public void modifyExistCourseById(int id, Course course) {
        Course findedCourse = fetchCourseById(id);
        findedCourse.setCourseName(course.getCourseName());
        findedCourse.setDescription(course.getDescription());
        findedCourse.setPrice(course.getPrice());
        findedCourse.setSuitableObject(course.getSuitableObject());
        findedCourse.setNotes(course.getNotes());
        findedCourse.setRemark(course.getRemark());
        findedCourse.setCourseName(course.getCourseName());
    }
}
