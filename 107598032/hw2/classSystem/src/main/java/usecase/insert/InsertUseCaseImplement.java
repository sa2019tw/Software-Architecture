package usecase.insert;

import dao.CourseDaoInterface;
import model.Course;
import usecase.input.insert.InsertInputInterface;
import usecase.output.InsertOutputInterface;

public class InsertUseCaseImplement implements InsertUseCaseInterface {
    private CourseDaoInterface courseDao;
    @Override
    public void setRepository(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void execute(InsertInputInterface input, InsertOutputInterface output) {
        Course course = new Course(
                input.getId(),
                input.getName(),
                input.getContent(),
                input.getMember(),
                input.getPrice(),
                input.getNotice(),
                input.getRemark());
        try {
            courseDao.insertCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            output.reportError(e.getMessage());
        }
    }
}
