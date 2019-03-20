package servlet;

import input.CourseInput;
import error.CourseError;
import usecase.addCourseUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addCourse")
public class addCourse extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/addCourse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        CourseInput input = new CourseInput(
                Integer.parseInt(request.getParameter("price")),
                0,
                request.getParameter("CourseName"),
                request.getParameter("note"),
                request.getParameter("remark"),
                request.getParameter("suitable"),
                request.getParameter("description")
        );

        CourseError error = new CourseError();
        addCourseUseCase course = new addCourseUseCase(input,error);

        if(error.isError()){
           // request.getRequestDispatcher().forward(request,response);
        }else{
            response.sendRedirect("CourseHome");
        }
    }
}
