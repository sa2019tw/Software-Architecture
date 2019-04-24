package servlet;
import dao.MySQLCourseDaoImplement;
import presenter.ListPresenter;
import usecase.input.list.ListInputImplement;
import usecase.list.ListUseCaseImplement;
import usecase.list.ListUseCaseInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/List")
public class ListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ListUseCaseInterface listUseCase = new ListUseCaseImplement();
        listUseCase.setRepository(new MySQLCourseDaoImplement());
        ListPresenter presenter = new ListPresenter();
        listUseCase.execute(new ListInputImplement(), presenter);
        if(presenter.isSuccess()) {
            request.setAttribute("courseList", presenter.buildViewModel().getCourses());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(presenter.getMessage());
        }
    }
}
