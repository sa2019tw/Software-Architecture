package servlet;

import dao.MySqlCourseDao;
import io.UseCaseOutput;
import io.UseCaseInput;
import io.UseCaseError;
import usecase.UpdateCourseUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateCourseServlet extends HttpServlet {
    private int id = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        id = Integer.parseInt(request.getParameter("id"));
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

        UpdateCourseUseCase updateCourseUseCase = new UpdateCourseUseCase(new MySqlCourseDao());

        UseCaseOutput output = updateCourseUseCase.getcourse(input, error);

        if(error.hasError()){
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            log(error.getErrorMessage());
        } else {
            request.setAttribute("course", output);
            request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String coursename = request.getParameter("coursename");
        String level = request.getParameter("level");
        String price_tmp = request.getParameter("courseprice");
        int price = 0;
        if(price_tmp.length() > 0){
            price = Integer.parseInt(price_tmp);
        }
        String description = request.getParameter("coursedescription");
        String precautions = request.getParameter("precautions");
        String remarks = request.getParameter("remarks");

        UseCaseInput input = new UseCaseInput(
                id,
                coursename,
                level,
                price,
                description,
                precautions,
                remarks
        );
        UseCaseError error = new UseCaseError();

        UpdateCourseUseCase updatecourse = new UpdateCourseUseCase(new MySqlCourseDao());
        updatecourse.update(input, error);

        if (error.hasError()){
            response.sendRedirect("/error");
            log(error.getErrorMessage());
        }else {
            response.sendRedirect("/list");
        }
    }
}
