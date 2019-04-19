package usecase.courseCommandFactory;

import usecase.CourseCommand;
import usecase.input.CourseDTO;
import usecase.output.OutputBoundary;

public interface CourseCommandFactory {
    CourseCommand createCreateCourseCommand(CourseDTO input, OutputBoundary output);
    CourseCommand createGetAllCourseCommand(OutputBoundary output);
    CourseCommand createModifyCourseCommand(CourseDTO input, OutputBoundary output);
    CourseCommand createDeleteCourseCommand(CourseDTO input, OutputBoundary output);
}
