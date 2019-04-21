package usecase.list;

import dao.CourseDaoInterface;
import usecase.input.list.ListInputInterface;
import usecase.output.list.ListOutputInterface;

public class ListUseCaseImplement implements ListUseCaseInterface {
    private CourseDaoInterface courseDao;
    @Override
    public void setRepository(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }


    @Override
    public void execute(ListInputInterface input, ListOutputInterface output) {
        try {
            output.setCourses(courseDao.getCourseList());
        } catch (Exception e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
