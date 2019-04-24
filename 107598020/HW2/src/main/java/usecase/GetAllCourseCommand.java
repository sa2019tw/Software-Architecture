package usecase;

import entity.Course;
import usecase.input.CourseDTO;
import usecase.mapper.CourseMapper;
import usecase.output.OutputBoundary;

import java.util.List;

public class GetAllCourseCommand implements CourseCommand {
    private CourseDao database;
    private OutputBoundary output;

    public GetAllCourseCommand(CourseDao database, OutputBoundary output) {
        this.database = database;
        this.output = output;
    }

    public void execute() throws Exception {
        List<Course> results = database.getAllCourses();

        CourseMapper courseMapper = new CourseMapper();
        List<CourseDTO> transferCourse = courseMapper.mapperToCourseDTO(results);

        output.setCoursesList(transferCourse);
    }
}
