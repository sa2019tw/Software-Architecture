package servlet;

import dao.CourseDao;
import error.CourseError;
import input.CourseInput;
import model.Course;
import output.CourseOutput;
import usecase.CourseHomeUseCase;
import usecase.editCourseUseCase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/editCourse")
public class editCourse extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int ID = Integer.parseInt(request.getParameter("ID"));

        CourseOutput output = new CourseOutput();
        CourseError error = new CourseError();
        editCourseUseCase course = new editCourseUseCase(ID,output,error);

        if(error.isError()){
            //
        }else{
            request.setAttribute("editCourse", output.getCourse());
            request.getRequestDispatcher("/WEB-INF/editCourse.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        CourseInput input = new CourseInput();
        input.setName(request.getParameter("CourseName"));
        input.setNumberOfPeople(Integer.parseInt(request.getParameter("number")));
        input.setPrice(Integer.parseInt(request.getParameter("price")));
        input.setNote(request.getParameter("note"));
        input.setRemark(request.getParameter("remark"));
        input.setSuitable(request.getParameter("suitable"));
        input.setDescription(request.getParameter("description"));
        input.setID(Integer.parseInt(request.getParameter("ID")));

        CourseOutput output = new CourseOutput();
        CourseError error = new CourseError();
        editCourseUseCase edit = new editCourseUseCase(input,error);

        if(error.isError()){
            // request.getRequestDispatcher().forward(request,response);
        }else{
            response.sendRedirect("CourseHome");
        }
    }
}
