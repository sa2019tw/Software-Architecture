package Presenter;

import Domain.Course;
import UseCase.CourseDTO;

import java.util.ArrayList;
import java.util.Collection;

public class ViewModel {

    private CourseDTO selectedCourseDTO;
    private Collection<CourseDTO> courseCollection = new ArrayList<CourseDTO>();




    private Course selectedCourse;

    private ArrayList<Course> courseList = new ArrayList<Course>();

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    //  DTO

    public CourseDTO getSelectedCourseDTO() {
        return selectedCourseDTO;
    }

    public void setSelectedCourseDTO(CourseDTO selectedCourseDTO) {
        this.selectedCourseDTO = selectedCourseDTO;
    }

    public Collection<CourseDTO> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<CourseDTO> courseCollection) {
        this.courseCollection = courseCollection;
    }
}
