package servlet;

import dao.MySqlCourseDao;
import usecase.ReadAllCourseUseCaseInterface;
import usecase.io.CreatUseCaseIO.CreatUseCaseOutput;
import usecase.io.CreatUseCaseIO.CreatUseCaseError;
import usecase.ReadAllCourseUseCase;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseError;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseErrorInterface;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseOutput;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseOutputInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        ReadAllUseCaseOutputInterface outputs = new ReadAllUseCaseOutput();
        ReadAllUseCaseErrorInterface error = new ReadAllUseCaseError();

        ReadAllCourseUseCaseInterface readAllCourseUseCase = new ReadAllCourseUseCase(new MySqlCourseDao());

        readAllCourseUseCase.ReadAllCourse(outputs, error);

        if(error.hasError()){
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            log(error.getErrorMessage());
        } else {
            request.setAttribute("list", outputs.getCourseDto());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
        }
    }
}
