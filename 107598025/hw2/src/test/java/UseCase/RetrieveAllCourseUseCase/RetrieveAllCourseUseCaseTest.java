package UseCase.RetrieveAllCourseUseCase;

import Dao.ICourseDao;
import Dao.MockCourseDao;
import Entity.Course;
import Output.OutputData;
import Output.RetrieveAllCourseOutputData;
import Output.RetrieveOneCourseOutputData;
import Presenter.RetrieveAllCoursePresenter;
import Presenter.RetrieveOneCoursePresenter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RetrieveAllCourseUseCaseTest {
    private ICourseDao courseDao = new MockCourseDao();

    @Test
    public void execute() {
        Course course = new Course("test1", "this is a test", "everyone", 10000, "attention", "remark");
        courseDao.addCourse(course);

        List<Course> courseList = courseDao.retrieveAllCourse();

        assertEquals(1, courseList.size());
    }

    @Test
    public void PresenterTest(){
        Course course1 = new Course("test1", "this is a test", "everyone", 10000, "attention", "remark");
        courseDao.addCourse(course1);

        Course course2 = new Course("test2", "this is a test2", "everyone22", 100000, "attentions", "remarks");
        courseDao.addCourse(course2);

        List<Course> courseList = courseDao.retrieveAllCourse();

        List<OutputData> outputDataList = new ArrayList<>();
        for(Course course: courseList){
            RetrieveAllCourseOutputData retrieveAllCourseOutputData = new RetrieveAllCourseOutputData(course.getCourseName(),
                    course.getCourseDescription(),
                    course.getCourseTarget(),
                    course.getCoursePrice(),
                    course.getCourseAttention(),
                    course.getCourseRemark());
            outputDataList.add(retrieveAllCourseOutputData);
        }
        RetrieveAllCoursePresenter retrieveAllCoursePresenter = new RetrieveAllCoursePresenter();
        retrieveAllCoursePresenter.setOutputDataList(outputDataList);

        retrieveAllCoursePresenter.buildViewModel();
        assertEquals(2, retrieveAllCoursePresenter.getViewModel().getViewModelList().size());
    }
}