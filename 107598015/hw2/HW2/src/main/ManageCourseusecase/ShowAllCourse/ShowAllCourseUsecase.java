package main.ManageCourseusecase.ShowAllCourse;

import main.Repository.ICourseDao;

public class ShowAllCourseUsecase {
    private ICourseDao iCourseDao;
    public ShowAllCourseUsecase(ICourseDao iCourseDao)
    {
        this.iCourseDao=iCourseDao;
    }
    public void execute(ShowAllCourseInput input, ShowAllCourseOutput output) {
       output.setAllCourse( iCourseDao.show());
    }

}
