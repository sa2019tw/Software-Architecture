package usecase;

import dao.CourseDao;
import model.Course;

import java.sql.SQLException;
import java.util.List;

public class DeleteCoursesUseCase {
    private CourseDao courseDao;

    public DeleteCoursesUseCase(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void execute(CourseInput input, CourseOutput output) {
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
