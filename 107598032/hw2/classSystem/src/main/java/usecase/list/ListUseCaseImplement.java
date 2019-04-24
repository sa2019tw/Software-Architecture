package usecase.list;

import dao.CourseDaoInterface;
import dto.CourseDto;
import model.Course;
import usecase.input.list.ListInputInterface;
import usecase.output.ListOutputInterface;

import java.util.ArrayList;
import java.util.List;

public class ListUseCaseImplement implements ListUseCaseInterface {
    private CourseDaoInterface courseDao;
    private List<CourseDto> courseDtos = new ArrayList<>();
    @Override
    public void setRepository(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    private void convert(List<Course> courses){
        for(Course course: courses){
            CourseDto courseDto = new CourseDto(
              course.getId(),
              course.getName(),
              course.getContent(),
              course.getMember(),
              course.getPrice(),
              course.getNotice(),
              course.getRemark()
            );
            courseDtos.add(courseDto);
        }
    }

    @Override
    public void execute(ListInputInterface input, ListOutputInterface output) {
        try {
            convert(courseDao.getCourseList());
            output.setCourses(courseDtos);
        } catch (Exception e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
