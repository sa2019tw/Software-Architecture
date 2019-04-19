package usecase.edit;

import dao.CourseDaoInterface;
import model.Course;
import usecase.input.InputInterface;
import usecase.input.edit.EditInputImplement;
import usecase.output.OutputInterface;
import usecase.output.edit.EditOutputImplement;

public class EditUseCaseImplement implements EditUseCaseInterface {
    private CourseDaoInterface courseDao;
    @Override
    public void setRepository(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void execute(EditInputImplement input, EditOutputImplement output) {
        Course course = new Course(
                input.getId(),
                input.getName(),
                input.getContent(),
                input.getMember(),
                input.getPrice(),
                input.getNotice(),
                input.getRemark());
        try {
            courseDao.updateCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
