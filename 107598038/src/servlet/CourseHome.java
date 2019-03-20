package servlet;

import dao.CourseDao;
import error.CourseError;

import output.CourseOutput;
import usecase.CourseHomeUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CourseHome")
public class CourseHome extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        CourseOutput output = new CourseOutput();
        CourseError error = new CourseError();
        CourseHomeUseCase course = new CourseHomeUseCase(output,error);

        if(error.isError()){
            //
        }else{
            request.setAttribute("courseAll", output.getList());
            request.getRequestDispatcher("/WEB-INF/CourseHome.jsp").forward(request, response);
        }
    }
}
