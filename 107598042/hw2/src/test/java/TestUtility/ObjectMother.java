package TestUtility;

import Domain.*;
import Gateway.InMemoryCourseBase;
import Presenter.*;
import UseCase.CourseDTO;
import UseCase.CourseDTOMapper;

public class ObjectMother {
    /*
    static public Presenter createPresenter() {
        Presenter presenter = new Presenter(new CourseManageUseCase(new InMemoryCourseBase()));
        return presenter;
    }


    static public Presenter createPresenterGivenDefaultTwoCourse() {
        Presenter presenter = new Presenter(new CourseManageUseCase(createCourseBaseGivenDefaultTwoCourse()));
        return presenter;
    }
*/
    static public CourseBase createCourseBaseGivenDefaultTwoCourse() {
        CourseBase courseBase = new InMemoryCourseBase();
        courseBase.createNewCourse(createCourse("OOAD"));
        courseBase.createNewCourse(createCourse("POSD"));
        return courseBase;
    }

    static public Course createCourse(String courseName) {
        Course course = new Course(courseName);
        course.setDescription("This course is about software tesing");
        course.setPrice(1999.0);
        course.setNotes("Freshman only");
        course.setRemark("None");
        course.setSuitableObject("Programmer");
        return course;
    }

    static public CourseInputDTO createCourseInputDAO(String courseName) {
        String description = "This course is about software tesing";
        int price = 1999;
        String notes = "Freshman only";
        String remark = "None";
        String suitableObject = "Programmer";
        CourseInputDTO courseDAO = new CourseInputDTO(courseName, description, notes, remark, suitableObject, price);
        return courseDAO;
    }

    static public CourseBase createCourseBase() {
        CourseBase courseBase = new InMemoryCourseBase();
        courseBase.createNewCourse(createCourse("OOAD"));
        courseBase.createNewCourse(createCourse("POSD"));
        return courseBase;
    }

//    static public CourseManageUseCase createCRUDCourseUseCase(CourseBase courseBase) {
//        return new CourseManageUseCase(courseBase);
//    }

    public static CourseDTO createCourseDTO(String courseNamne) {

        return new CourseDTOMapper()
                .mappingCourseDomainToCourseDTO(createCourse(courseNamne));
    }
}
