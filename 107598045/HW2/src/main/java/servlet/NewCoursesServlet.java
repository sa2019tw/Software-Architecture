package servlet;

import dao.impl.CourseDaoImpl;
import usecase.CourseInput;
import usecase.CourseOutput;
import usecase.NewCoursesUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by David on 2019 / 02 / 27.
 */
@WebServlet("/newCourses")
public class NewCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/newCourses.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");

        String course_name = request.getParameter("course_name");
        String course_detail = request.getParameter("course_detail");
        String course_suit_people = request.getParameter("course_suit_people");
        int course_price = Integer.parseInt(request.getParameter("course_price"));
        String course_notes = request.getParameter("course_notes");
        String course_remark = request.getParameter("course_remark");

        CourseInput input = new CourseInput(
                course_name,
                course_detail,
                course_suit_people,
                course_price,
                course_notes,
                course_remark
        );
        CourseOutput output = new CourseOutput();

        NewCoursesUseCase insert = new NewCoursesUseCase(new CourseDaoImpl());
        insert.execute(input, output);

        if(output.hasErrorOccur()){
            System.out.println(output.getErrorMessage());
        } else{
            response.sendRedirect("listAllCourses");
        }
    }
}
