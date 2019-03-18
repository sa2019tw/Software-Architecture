package UseCase;


import Domain.Course;
import Domain.CourseBase;
import Domain.OutputBoundary.OutputBoundary;
import Presenter.CourseInputDTO;

import java.util.ArrayList;
import java.util.Collection;

public class CourseManageUseCase {
    private CourseBase courseBase;
    private OutputBoundary outputBoundary;

    public CourseManageUseCase(CourseBase courseBase) {
        this.courseBase = courseBase;
    }

    public Course transformDAOIntoCourseEntity(CourseInputDTO courseInputDAO) {
        Course course = Course.createCourse(courseInputDAO.courseName);
        course.setDescription(courseInputDAO.description);
        course.setNotes(courseInputDAO.notes);
        course.setSuitableObject(courseInputDAO.suitableObject);
        course.setRemark(courseInputDAO.remark);
        course.setPrice(courseInputDAO.price);
        return course;
    }

    public void setOutputBoundary(OutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public Collection<CourseDTO> fetchAllCourses() {
        sendDTOCollectionAcrossOutputBoundary();
        return this.fetchAllCourseDTO();
    }

    private CourseDTO mappingCourseDomainToCourseDTO(Course course) {
        return new CourseDTOMapper()
                .mappingCourseDomainToCourseDTO(course);
    }

    public Collection<CourseDTO> fetchAllCourseDTO() {
        ArrayList<Course> courseList = this.courseBase.fetchAllCourse();

        Collection<CourseDTO> courseDTOCollection = new ArrayList<CourseDTO>();

        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);

            CourseDTO courseDTO = mappingCourseDomainToCourseDTO(course);
            courseDTOCollection.add(courseDTO);
        }

        return courseDTOCollection;
    }

    public CourseDTO fetchCourseById(int identifier) {
        Course course = this.courseBase.fetchCourseById(identifier);
        CourseDTO courseDTO =  mappingCourseDomainToCourseDTO(course);

        if (outputBoundary != null)
            this.outputBoundary.setCourseDTO(courseDTO);

        return courseDTO;
    }

    public void deleteCourseById(int identifier) {
        this.courseBase.deleteCourseById(identifier);

        sendDTOCollectionAcrossOutputBoundary();
    }

    public void createCourse(CourseInputDTO courseInputDTO) {
        Course course = transformDAOIntoCourseEntity(courseInputDTO);
        this.courseBase.createNewCourse(course);
        sendDTOCollectionAcrossOutputBoundary();
    }

    public void modifyCourse(CourseInputDTO courseInputDTO) {
        Course course = this.transformDAOIntoCourseEntity(courseInputDTO);
        this.courseBase.modifyExistCourseById(courseInputDTO.getId(), course);

        sendDTOCollectionAcrossOutputBoundary();
    }

    public void sendDTOCollectionAcrossOutputBoundary() {
        Collection<CourseDTO> courseDTOCollection = this.fetchAllCourseDTO();

        if (outputBoundary != null)
            this.outputBoundary.setCourseDTOCollection(courseDTOCollection);

    }
}