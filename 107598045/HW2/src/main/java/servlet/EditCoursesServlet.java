package servlet;

import dao.impl.CourseDaoImpl;
import usecase.CourseInput;
import usecase.CourseOutput;
import usecase.update.EditCoursesUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Created by David on 2019 / 03 / 01.
 */
@WebServlet("/editCourses")
public class EditCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String i = request.getParameter("id");

        CourseInput input = new CourseInput();
        input.setCourseId(parseInt(i));
        CourseOutput output = new CourseOutput();
        EditCoursesUseCase editCourseUseCase = new EditCoursesUseCase(new CourseDaoImpl());

        editCourseUseCase.getTheCourse(input, output);

        if(output.hasErrorOccur()){
            System.out.println(output.getErrorMessage());
        } else {
            request.setAttribute("course_id", output.getTheCourse().getCourseId());
            request.setAttribute("course_name", output.getTheCourse().getCourseName());
            request.setAttribute("course_detail", output.getTheCourse().getCourseDetail());
            request.setAttribute("course_suit_people", output.getTheCourse().getCourseSuitPeople());
            request.setAttribute("course_price", output.getTheCourse().getCoursePrice());
            request.setAttribute("course_notes", output.getTheCourse().getCourseNotes());
            request.setAttribute("course_remark", output.getTheCourse().getCourseRemark());
            request.getRequestDispatcher("/WEB-INF/jsp/editCourses.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String course_id = request.getParameter("course_id");
        String course_name = request.getParameter("course_name");
        String course_detail = request.getParameter("course_detail");
        String course_suit_people = request.getParameter("course_suit_people");
        String course_price = request.getParameter("course_price");
        String course_notes = request.getParameter("course_notes");
        String course_remark = request.getParameter("course_remark");

        CourseInput input = new CourseInput(
                course_name,
                course_detail,
                course_suit_people,
                parseInt(course_price),
                course_notes,
                course_remark
        );
        input.setCourseId(parseInt(course_id));
        CourseOutput output = new CourseOutput();
        EditCoursesUseCase editCourseUseCase = new EditCoursesUseCase(new CourseDaoImpl());

        editCourseUseCase.editTheCourseToDB(input, output);

        if(output.hasErrorOccur()){
            System.out.println(output.getErrorMessage());
        } else {
            response.sendRedirect("/listAllCourses"); //使用這個方會跑doGet
        }
    }
}
