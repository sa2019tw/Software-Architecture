package servlet;

import dao.MySqlCourseDao;
import usecase.DeleteCourseUseCaseInterface;
import usecase.io.CreatUseCaseIO.CreatUseCaseInput;
import usecase.io.CreatUseCaseIO.CreatUseCaseError;
import usecase.DeleteCourseUseCase;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseError;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseErrorInterface;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseInput;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseInputInterface;

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
        DeleteCourseUseCaseInterface deletecourse = new DeleteCourseUseCase(new MySqlCourseDao());
        DeleteUseCaseInputInterface input = new DeleteUseCaseInput(
                id,
                null,
                null,
                0,
                null,
                null,
                null
        );
        DeleteUseCaseErrorInterface error = new DeleteUseCaseError();

        deletecourse.deleteCourse(input, error);
        
        if(error.hasError()){
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            log(error.getErrorMessage());
        } else {
            response.sendRedirect("/list");
        }
    }
}