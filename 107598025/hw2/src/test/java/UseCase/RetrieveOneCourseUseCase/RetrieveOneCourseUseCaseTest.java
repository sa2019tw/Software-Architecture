package UseCase.RetrieveOneCourseUseCase;

import Controller.InputModel;
import Dao.ICourseDao;
import Dao.MockCourseDao;
import Entity.Course;
import Output.OutputData;
import Output.RetrieveOneCourseOutputData;
import Presenter.RetrieveAllCoursePresenter;
import Presenter.RetrieveOneCoursePresenter;
import UseCase.OutputBoundary;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetrieveOneCourseUseCaseTest {

    private ICourseDao courseDao = new MockCourseDao();

    @Test
    public void execute() {
        Course course = new Course("test1", "this is a test", "everyone", 10000, "attention", "remark");
        courseDao.addCourse(course);

        Course targetCourse = courseDao.retrieveOneCourse(course.getCourseName());

        assertEquals(course, targetCourse);
    }

    @Test
    public void PresenterTest(){
        Course course = new Course("test1", "this is a test", "everyone", 10000, "attention", "remark");
        courseDao.addCourse(course);

        OutputData retrieveOneCourseOutputData = new RetrieveOneCourseOutputData(course.getCourseName(),
                                                                        course.getCourseDescription(),
                                                                        course.getCourseTarget(),
                                                                        course.getCoursePrice(),
                                                                        course.getCourseAttention(),
                                                                        course.getCourseRemark());

        RetrieveOneCoursePresenter retrieveOneCoursePresenter = new RetrieveOneCoursePresenter();
        retrieveOneCoursePresenter.setOutputData(retrieveOneCourseOutputData);

        retrieveOneCoursePresenter.buildViewModel();
        assertEquals("test1", retrieveOneCoursePresenter.getViewModel().getCourseName());
    }
}