package usecase.courseCommandFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import usecase.*;
import usecase.input.CourseDTO;
import usecase.output.OutputBoundary;

public class CourseCommandFactoryImp implements CourseCommandFactory {
    private final Provider<CourseDao> courseDaoProvider;

    @Inject
    public CourseCommandFactoryImp(Provider<CourseDao> courseDaoProvider) {
        this.courseDaoProvider = courseDaoProvider;
    }

    public CourseCommand createCreateCourseCommand(CourseDTO input, OutputBoundary output) {
        return new CreateCourseCommand(courseDaoProvider.get(), input, output);
    }

    public CourseCommand createGetAllCourseCommand(OutputBoundary output) {
        return new GetAllCourseCommand(courseDaoProvider.get(), output);
    }

    public CourseCommand createModifyCourseCommand(CourseDTO input, OutputBoundary output) {
        return new ModifyCourseCommand(courseDaoProvider.get(), input, output);
    }

    public CourseCommand createDeleteCourseCommand(CourseDTO input, OutputBoundary output) {
        return new DeleteCourseCommand(courseDaoProvider.get(), input, output);
    }
}
