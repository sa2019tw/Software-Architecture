package servlet;

import input.addCourse.addCourseInput;
import input.addCourse.addCourseInputImpl;
import presenter.addCoursePresenter;
import usecase.addCourse.addCourseUseCaseImpl;

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
        addCourseInput input = new addCourseInputImpl(
                Integer.parseInt(request.getParameter("price")),
                0,
                request.getParameter("CourseName"),
                request.getParameter("note"),
                request.getParameter("remark"),
                request.getParameter("suitable"),
                request.getParameter("description")
        );

        addCoursePresenter presenter = new addCoursePresenter();
        addCourseUseCaseImpl UC = new addCourseUseCaseImpl();

        UC.execute(input,presenter);

        if(presenter.getCourseError().isError()){
            request.getRequestDispatcher("/WEB-INF/warning.jsp").forward(request,response);
        }else
            response.sendRedirect("CourseHome");
    }
}
