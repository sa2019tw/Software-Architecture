package usecase.insert;

import dao.CourseDaoInterface;
import model.Course;
import usecase.input.InputInterface;
import usecase.input.insert.InsertInputImplement;
import usecase.input.insert.InsertInputInterface;
import usecase.output.OutputInterface;
import usecase.output.insert.InsertOutputImplement;
import usecase.output.insert.InsertOutputInterface;

import java.sql.SQLException;

public class InsertUseCaseImplement implements InsertUseCaseInterface {
    private CourseDaoInterface courseDao;
    @Override
    public void setRepository(CourseDaoInterface courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void execute(InsertInputImplement input, InsertOutputImplement output) {
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
