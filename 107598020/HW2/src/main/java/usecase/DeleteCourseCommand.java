package usecase;

import usecase.input.CourseDTO;
import usecase.mapper.CourseMapper;
import usecase.output.OutputBoundary;

public class DeleteCourseCommand implements CourseCommand {
    private CourseDao dataBase;
    private CourseDTO courseDTO;
    private OutputBoundary output;

    public DeleteCourseCommand(CourseDao database, CourseDTO courseDTO, OutputBoundary output) {
        this.dataBase = database;
        this.courseDTO = courseDTO;
        this.output = output;
    }

    public void execute() throws Exception {
        CourseMapper mapper = new CourseMapper();
        dataBase.deleteCourse(mapper.mapperToCourse(courseDTO));

        output.setCoursesList(mapper.mapperToCourseDTO(dataBase.getAllCourses()));
    }
}
