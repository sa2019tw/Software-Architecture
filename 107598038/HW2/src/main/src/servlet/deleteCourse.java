package servlet;

import input.deleteCourse.deleteCourseInput;
import input.deleteCourse.deleteCourseInputImpl;
import presenter.deleteCoursePresenter;
import usecase.deleteCourse.deleteCourseUseCase;
import usecase.deleteCourse.deleteCourseUseCaseImpl;

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
        deleteCourseInput input = new deleteCourseInputImpl(ID);
        deleteCoursePresenter presenter = new deleteCoursePresenter();

        deleteCourseUseCase UC = new deleteCourseUseCaseImpl();
        UC.execute(input,presenter);

        if(presenter.getCourseError().isError()){
            request.getRequestDispatcher("/WEB-INF/warning.jsp").forward(request,response);
        }else
          response.sendRedirect("CourseHome");
    }
}
