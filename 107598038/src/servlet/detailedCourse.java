package servlet;


import error.CourseError;
import output.CourseOutput;
import usecase.detailedCourseUseCase;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/detailedCourse")
public class detailedCourse extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int ID = Integer.parseInt(request.getParameter("ID"));

        CourseOutput output = new CourseOutput();
        CourseError error = new CourseError();
        detailedCourseUseCase course = new detailedCourseUseCase(ID,output,error);

        if(error.isError()){
            //
        }else{
            request.setAttribute("course", output.getCourse());
            request.getRequestDispatcher("/WEB-INF/detailedCourse.jsp").forward(request, response);
        }
    }
}
