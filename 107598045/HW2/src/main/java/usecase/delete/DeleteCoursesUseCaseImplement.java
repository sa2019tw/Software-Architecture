package usecase.delete;

import dao.CourseDao;
import model.Course;
import org.junit.Test;
import usecase.delete.input.DeleteInput;
import usecase.delete.output.DeleteOutput;

import java.sql.SQLException;
import java.util.List;

public class DeleteCoursesUseCaseImplement implements DeleteCoursesUseCase{
    private CourseDao courseDao;

    public DeleteCoursesUseCaseImplement(){}

    @Override
    public void setRepository(CourseDao courseDao){
        this.courseDao = courseDao;
    }

    public void execute(DeleteInput input, DeleteOutput output) {
        String[] choiceCourseId = input.getChoiceCourseId();
        if(choiceCourseId != null){
            for(String courseid: choiceCourseId) {
                try {
                    courseDao.deleteCourseToDB(Integer.parseInt(courseid));
                } catch (SQLException e) {
                    e.printStackTrace();
                    output.reportError(e.getMessage());
                }
            }
        }
    }

}
