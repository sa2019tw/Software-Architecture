package servlet;

import dao.CourseDao;
import input.CourseInput;
import error.CourseError;
import usecase.deleteCourseUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteCourse")
public class deleteCourse extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int ID = Integer.parseInt(request.getParameter("ID"));
        CourseInput input = new CourseInput();
        input.setID(ID);

        CourseError error = new CourseError();
        deleteCourseUseCase course = new deleteCourseUseCase(input,error);

        try {
            CourseDao courseDao = new CourseDao();
            courseDao.deleteCourse(ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("CourseHome");
    }
}
