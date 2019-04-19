package servlet;

import dao.MySqlCourseDao;
import io.UseCaseInput;
import io.UseCaseError;
import usecase.DeleteCourseUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/list");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        DeleteCourseUseCase deletecourse = new DeleteCourseUseCase(new MySqlCourseDao());
        UseCaseInput input = new UseCaseInput(
                id,
                null,
                null,
                0,
                null,
                null,
                null
        );
        UseCaseError error = new UseCaseError();

        deletecourse.deleteCourse(input, error);
        
        if(error.hasError()){
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            log(error.getErrorMessage());
        } else {
            response.sendRedirect("/list");
        }
    }
}