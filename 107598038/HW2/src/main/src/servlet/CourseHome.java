package servlet;

import input.CouseHome.CourseHomeImpl;
import input.CouseHome.CourseHomeInput;
import presenter.CourseHomePresenter;
import usecase.CourseHome.CourseHomeUseCaseImpl;
import view.CourseHomeViewModel;
import view.ViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CourseHome")
public class CourseHome extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        CourseHomeInput input = new CourseHomeImpl();
        CourseHomePresenter presenter = new CourseHomePresenter();

        CourseHomeUseCaseImpl UC = new CourseHomeUseCaseImpl();
        UC.execute(input,presenter);

        if (presenter.getCourseError().isError()){
            request.getRequestDispatcher("/WEB-INF/warning.jsp").forward(request,response);
        }else{
            ViewModel view = presenter.createView();
            request.setAttribute("courseAll", ((CourseHomeViewModel) view).getCourseAll());
            request.getRequestDispatcher("/WEB-INF/CourseHome.jsp").forward(request, response);
        }
    }
}
