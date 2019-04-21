package servlet;
import dao.MySQLCourseDaoImplement;
import usecase.input.list.ListInputImplement;
import usecase.input.list.ListInputInterface;
import usecase.list.ListUseCaseImplement;
import usecase.list.ListUseCaseInterface;
import usecase.output.list.ListOutputImplement;
import usecase.output.list.ListOutputInterface;

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
        ListInputInterface input = new ListInputImplement();
        ListOutputInterface output = new ListOutputImplement();
        listUseCase.execute(input, output);
        if(output.isSuccess()) {
            request.setAttribute("courseList", output.getCourses());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(output.getMessage());
        }
    }
}
