package usecase.delete;

import dao.CourseDaoInterface;
import usecase.input.delete.DeleteInputInterface;
import usecase.output.DeleteOutputInterface;

public class DeleteUseCaseImplement implements DeleteUseCaseInterface {
    private CourseDaoInterface courseDao;
    @Override
    public void setRepository(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void execute(DeleteInputInterface input, DeleteOutputInterface output) {
        try {
            for(int id: input.getIdList()){
                courseDao.deleteCourse(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
