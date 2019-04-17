package servlet;

import input.editCourse.editCourseInput;
import input.editCourse.editCourseInputImpl;
import input.findCourse.findCourseInput;
import input.findCourse.findCourseInputImpl;
import presenter.editCoursePresenter;
import presenter.findCoursePresenter;
import usecase.editCourse.editCourseUseCase;
import usecase.editCourse.editCourseUseCaseImpl;
import usecase.findCourse.findCourseUseCase;
import usecase.findCourse.findCourseUseCaseImpl;
import view.ViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/editCourse")
public class editCourse extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int ID = Integer.parseInt(request.getParameter("ID"));

        findCourseInput input = new findCourseInputImpl(ID);
        findCoursePresenter presenter = new findCoursePresenter();

        findCourseUseCase UC = new findCourseUseCaseImpl();
        UC.execute(input,presenter);

        if(presenter.getCourseError().isError()){
            request.getRequestDispatcher("/WEB-INF/warning.jsp").forward(request,response);
        }else{
            ViewModel view = presenter.createView();
            request.setAttribute("editCourse", view);
            request.getRequestDispatcher("/WEB-INF/editCourse.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        editCourseInput input = new editCourseInputImpl(
                Integer.parseInt(request.getParameter("ID")),
                Integer.parseInt(request.getParameter("price")),
                0,
                request.getParameter("CourseName"),
                request.getParameter("note"),
                request.getParameter("remark"),
                request.getParameter("suitable"),
                request.getParameter("description")
        );

        editCoursePresenter presenter = new editCoursePresenter();
        editCourseUseCase UC = new editCourseUseCaseImpl();
        UC.execute(input,presenter);

        if(presenter.getCourseError().isError()){
            request.getRequestDispatcher("/WEB-INF/warning.jsp").forward(request,response);
        }else
            response.sendRedirect("CourseHome");
    }
}
