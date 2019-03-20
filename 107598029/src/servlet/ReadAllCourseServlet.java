package servlet;

import io.UseCaseOutput;
import io.UseCaseError;
import usecase.ReadAllCourseUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/list")
public class ReadAllCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        UseCaseOutput output = new UseCaseOutput();
        UseCaseError error = new UseCaseError();

        ReadAllCourseUseCase listCourseUseCase = new ReadAllCourseUseCase();

        listCourseUseCase.listCourse(output, error);

        if(error.hasError()){
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            log(error.getErrorMessage());
        } else {
            request.setAttribute("list", output.getCourses());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
        }
    }
}
