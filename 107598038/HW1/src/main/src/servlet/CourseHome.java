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
        CourseDao excelCourseDao = null;
        try {
            excelCourseDao = new ExcelCourseDao();
            List<Course> courseAll = excelCourseDao.getCourseAll();
            request.setAttribute("courseAll", courseAll);
        } catch (Exception e ){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/CourseHome.jsp").forward(request, response);
    }
}
