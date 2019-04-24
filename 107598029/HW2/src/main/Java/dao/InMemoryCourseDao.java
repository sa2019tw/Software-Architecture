
package dao;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCourseDao implements CourseDaoInterface {
    private List<Course> courses = new ArrayList<>();

    public List<Course> readallcourse(){
        return courses;
    }
    public Course getcourseinfo(Integer id){
        for (Course each : courses) {
            if (each.getId() == id)
                return each;
        }
        return null;
    }

    public void creatcourse(Course course){
        courses.add(course);
    }

    public void updatecourse(Course course){
        for (Course each : courses) {
            if (each.getId() == course.getId()) {
                each.setName(course.getName());
                each.setLevel(course.getLevel());
                each.setDescription(course.getDescription());
                each.setPrice(course.getPrice());
                each.setPrecautions(course.getPrecautions());
                each.setRemarks(course.getRemarks());
            }
        }
    }
    public void deletecourse(Integer id){
        courses.forEach(each -> {
            if (each.getId() == id)
                courses.remove(each);
        });
    }
    public List<Course> findcourse(String cname){
//        for(int i=0; i<courses.size(); i++){
//            if(courses.get(i).getName().equals(cname))
//                courses.add(courses.get(i));
//        }
        List<Course> tmp = new ArrayList<>();
        for (Course each : courses) {
            if (each.getName() == cname)
                tmp.add(each);
        }
        return tmp;
    }
}