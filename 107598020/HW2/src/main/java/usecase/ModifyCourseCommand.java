package usecase;

import usecase.input.CourseDTO;
import usecase.mapper.CourseMapper;
import usecase.output.OutputBoundary;

public class ModifyCourseCommand implements CourseCommand {
    private CourseDao database;
    private CourseDTO input;
    private OutputBoundary output;

    public ModifyCourseCommand(CourseDao database, CourseDTO input, OutputBoundary output) {
        this.database = database;
        this.input = input;
        this.output = output;
    }

    public void execute() throws Exception {
        CourseMapper mapper = new CourseMapper();
        database.modifyCourse(mapper.mapperToCourse(input));

        output.setCoursesList(mapper.mapperToCourseDTO(database.getAllCourses()));
    }
}
