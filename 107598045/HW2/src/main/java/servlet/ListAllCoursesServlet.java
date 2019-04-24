package servlet;


import dao.impl.CourseDaoImpl;
import usecase.read.ListAllCoursesUseCase;
import usecase.read.ListAllCoursesUseCaseImplement;
import usecase.read.input.ListAllInput;
import usecase.read.input.ListAllInputImplement;
import usecase.read.output.ListAllOutput;
import usecase.read.output.ListAllOutputImplement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by David on 2019 / 02 / 23.
 */
@WebServlet("/listAllCourses")
public class ListAllCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        ListAllInput input = new ListAllInputImplement();
        ListAllOutput output = new ListAllOutputImplement();

        ListAllCoursesUseCase UseCase = new ListAllCoursesUseCaseImplement();
        UseCase.setRepository(new CourseDaoImpl());
        UseCase.execute(input, output);

        if(output.hasErrorOccur()){
            System.out.println(output.getErrorMessage());
        } else {
            request.setAttribute("courseList", output.getCourseList());
            request.getRequestDispatcher("/WEB-INF/jsp/listAllCourses.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        doGet(request, response);
    }
}
