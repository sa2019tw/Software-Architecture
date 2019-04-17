package servlet;

import dao.CourseDaoImpl;
import model.Course;
import useCase.InsertCourseUseCase;
import useCase.UseCaseInput;
import useCase.UseCaseOutput;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Insert")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/jsp/insert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        String[] memberList = request.getParameterValues("member");
        String memberString = "";
        if(memberList != null && memberList.length > 1){
            for(int i = 0; i < memberList.length; i++){
                if(i != 0) memberString += "/";
                memberString += memberList[i];
            }
        }
        else if(memberList != null && memberList.length == 1){
            memberString = memberList[0];
        }
        String priceTemp = request.getParameter("price");
        int price = 0;
        if(priceTemp.length() > 0)
            price = Integer.parseInt(request.getParameter("price"));
        String notice = request.getParameter("notice");
        String remark = request.getParameter("remark");
        InsertCourseUseCase insertCourseUseCase = new InsertCourseUseCase();
        insertCourseUseCase.setCourseDao(new CourseDaoImpl());
        UseCaseInput useCaseInput = new UseCaseInput(
                -1,
                name,
                content,
                memberString,
                price,
                notice,
                remark
        );
        UseCaseOutput useCaseOutput = new UseCaseOutput();
        insertCourseUseCase.execute(useCaseInput, useCaseOutput);
        if(useCaseOutput.isSuccess())
            request.getRequestDispatcher("/WEB-INF/jsp/insert.jsp").forward(request, response);
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(useCaseOutput.getMessage());
        }
    }
}
