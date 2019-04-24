package servlet;

import dao.MySqlCourseDao;
import usecase.UpdateCourseUseCaseInterface;
import usecase.io.CreatUseCaseIO.*;
import usecase.UpdateCourseUseCase;
import usecase.io.UpdateUseCaseIO.*;

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
        UpdateUseCaseInputInterface input = new UpdateUseCaseInput(
                id,
                null,
                null,
                0,
                null,
                null,
                null
        );
        UpdateUseCaseErrorInterface error = new UpdateUseCaseError();

        UpdateCourseUseCaseInterface updateCourseUseCase = new UpdateCourseUseCase(new MySqlCourseDao());

        UpdateUseCaseOutputInterface output = new UpdateUseCaseOutput();

        updateCourseUseCase.getcourse(input,output, error);

        if(error.hasError()){
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            log(error.getErrorMessage());
        } else {
            request.setAttribute("course", output.getCourseDto());
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

        UpdateUseCaseInputInterface input = new UpdateUseCaseInput(
                id,
                coursename,
                level,
                price,
                description,
                precautions,
                remarks
        );
        UpdateUseCaseErrorInterface error = new UpdateUseCaseError();
        UpdateCourseUseCaseInterface updatecourse = new UpdateCourseUseCase(new MySqlCourseDao());
        updatecourse.update(input, error);

        if (error.hasError()){
            response.sendRedirect("/error");
            log(error.getErrorMessage());
        }else {
            response.sendRedirect("/list");
        }
    }
}
