package servlet;
import dao.MySQLCourseDaoImplement;
import usecase.ListCourseUseCase;
import usecase.input.UseCaseInput;
import usecase.output.UseCaseOutput;

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
        ListCourseUseCase listCourseUseCase = new ListCourseUseCase();
        listCourseUseCase.setCourseDao(new MySQLCourseDaoImplement());
        UseCaseInput useCaseInput = new UseCaseInput(
                -1,
                "",
                "",
                "",
                -1,
                "",
                ""
        );
        UseCaseOutput useCaseOutput = new UseCaseOutput();
        listCourseUseCase.execute(useCaseInput, useCaseOutput);
        if(useCaseOutput.isSuccess()) {
            request.setAttribute("courseList", useCaseOutput.getCourses());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(useCaseOutput.getMessage());
        }
    }
}
