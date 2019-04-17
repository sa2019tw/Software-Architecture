package servlet;

import dao.CourseDao;
import dao.impl.CourseDaoImpl;
import model.Course;
import usecase.CourseInput;
import usecase.CourseOutput;
import usecase.DeleteCoursesUseCase;
import usecase.ListAllCoursesUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by David on 2019 / 03 / 01.
 */
@WebServlet("/deleteCourses")
public class DeleteCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        CourseInput input = new CourseInput();
        CourseOutput output = new CourseOutput();

        ListAllCoursesUseCase listAllCoursesUseCase = new ListAllCoursesUseCase(new CourseDaoImpl());  //使用 列出所有課程列表的use case
        listAllCoursesUseCase.execute(input, output);

        if(output.hasErrorOccur()){
            System.out.println(output.getErrorMessage());
        } else {
            request.setAttribute("courseList", output.getCourseList());
            request.getRequestDispatcher("/WEB-INF/jsp/deleteCourses.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String[] deleteCourseId = request.getParameterValues("deleteId");

        DeleteCoursesUseCase deleteUseCase = new DeleteCoursesUseCase(new CourseDaoImpl());
        CourseInput input = new CourseInput(deleteCourseId);
        CourseOutput output = new CourseOutput();

        deleteUseCase.execute(input, output);

        if(output.hasErrorOccur()){
            System.out.println(output.getErrorMessage());
        } else {
            response.sendRedirect("listAllCourses"); //使用這個方會跑doGet
        }
    }
}
