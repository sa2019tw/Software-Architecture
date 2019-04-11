package servlet;

import dao.CourseDao;
import dao.ExcelCourseDao;
import dao.MySQLCourseDao;
import model.Course;

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
        int ID = Integer.parseInt(request.getParameter("ID"));
        System.out.println(ID);
        CourseDao excelCourseDao = null;
        try {
            excelCourseDao = new ExcelCourseDao();
            Course course = excelCourseDao.selectCourse(ID);
            request.setAttribute("course",course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/detailedCourse.jsp").forward(request,response);
    }
}
