package servlet;

import input.detailedCourse.detailedCourseInput;
import input.detailedCourse.detailedCourseInputImpl;
import presenter.detailedCoursePresenter;
import usecase.detailedCourse.detailedCourseUseCaseImpl;
import view.ViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/detailedCourse")
public class detailedCourse extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int ID = Integer.parseInt(request.getParameter("ID"));

        detailedCourseInput input = new detailedCourseInputImpl(ID);
        detailedCoursePresenter presenter = new detailedCoursePresenter();

        detailedCourseUseCaseImpl UC = new detailedCourseUseCaseImpl();
        UC.execute(input,presenter);

        if(presenter.getCourseError().isError()){
            request.getRequestDispatcher("/WEB-INF/warning.jsp").forward(request,response);
        }else{
            ViewModel view = presenter.createView();
            request.setAttribute("course", view);
            request.getRequestDispatcher("/WEB-INF/detailedCourse.jsp").forward(request, response);
        }
    }
}
