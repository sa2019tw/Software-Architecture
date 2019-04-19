package servlet;


import dao.MySqlCourseDao;
import io.UseCaseInput;
import io.UseCaseError;
import io.UseCaseOutput;
import usecase.FindCourseUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/find")
public class FindCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String coursename = request.getParameter("cname");
        UseCaseInput input = new UseCaseInput(
                0,
                coursename,
                null,
                0,
                null,
                null,
                null
        );
        List<UseCaseOutput> outputs = new ArrayList<>();
        UseCaseError error = new UseCaseError();

        FindCourseUseCase findcourse = new FindCourseUseCase(new MySqlCourseDao());
        findcourse.find(input, outputs, error);

        if(error.hasError()){
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            log(error.getErrorMessage());
        } else {
            request.setAttribute("list", outputs);
            request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);
    }
}
