package usecase.list;

import dao.CourseDaoInterface;
import usecase.input.list.ListInputImplement;
import usecase.output.list.ListOutputImplement;

import java.sql.SQLException;

public class ListUseCaseImplement implements ListUseCaseInterface {
    private CourseDaoInterface courseDao;
    @Override
    public void setRepository(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }


    @Override
    public void execute(ListInputImplement input, ListOutputImplement output) {
        try {
            output.setCourses(courseDao.getCourseList());
        } catch (Exception e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
