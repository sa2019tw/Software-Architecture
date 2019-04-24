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


@WebServlet("/addCourse")
public class addCourse extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/addCourse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Course course = new Course();
        course.setName(request.getParameter("CourseName"));
        course.setDescription(request.getParameter("description"));
        course.setNote(request.getParameter("note"));
        course.setPrice(Integer.parseInt(request.getParameter("price")));
        course.setRemark(request.getParameter("remark"));
        course.setSuitable(request.getParameter("suitable"));
        course.setNumberOfPeople(0);
        System.out.println(course.getDescription());
        try {
            CourseDao excelCourseDao = new ExcelCourseDao();
            excelCourseDao.insertCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("CourseHome");
    }
}
