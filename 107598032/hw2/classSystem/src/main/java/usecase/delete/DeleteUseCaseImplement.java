package usecase.delete;

import dao.CourseDaoInterface;
import usecase.input.delete.DeleteInputImplement;
import usecase.output.delete.DeleteOutputImplement;

public class DeleteUseCaseImplement implements DeleteUseCaseInterface {
    private CourseDaoInterface courseDao;
    @Override
    public void setRepository(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void execute(DeleteInputImplement input, DeleteOutputImplement output) {
        try {
            courseDao.deleteCourse(input.getId());
        } catch (Exception e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
