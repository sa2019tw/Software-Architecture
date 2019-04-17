package dao;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCourseDaoImpl implements CourseDaoInterface{
    List<Course> courses = new ArrayList<>();

    public Course getCourseById(int id) {
        int i = 0;
        for (Course temp: courses){
            if(temp.getId() == id){
                return temp;
            }
            i++;
        }
        throw new NullPointerException("Not found!");
    }

    @Override
    public List<Course> getCourseList() {
        return courses;
    }

    @Override
    public void insertCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void deleteCourse(int id) {
        int i = 0;
        for (Course temp: courses){
            if(temp.getId() == id){
                courses.remove(i);
                return;
            }
            i++;
        }
    }

    @Override
    public void updateCourse(Course course) {
        int i = 0;
        for (Course temp: courses){
            if(temp.getId() == course.getId()){
                courses.get(i).setName(course.getName());
                courses.get(i).setContent(course.getContent());
                courses.get(i).setMember(course.getMember());
                courses.get(i).setPrice(course.getPrice());
                courses.get(i).setNotice(course.getNotice());
                courses.get(i).setRemark(course.getRemark());
                return;
            }
            i++;
        }
    }
}
