package servlet;

import dao.MySQLCourseDaoImplement;
import model.Course;
import usecase.*;
import usecase.input.UseCaseInput;
import usecase.output.UseCaseOutput;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer, Course> courseMap = new HashMap<>();
        Map<String, Integer> memberOption = new HashMap<>();
        String[] option = {"大一", "大二", "大三", "大四", "碩一", "碩二"};
        for(String str: option){
            memberOption.put(str, 0);
        }
        ListCourseUseCase listCourseUseCase = new ListCourseUseCase();
        listCourseUseCase.setCourseDao(new MySQLCourseDaoImplement());
        UseCaseInput useCaseInput = new UseCaseInput(
                -1,
                "",
                "",
                "",
                -1,
                "",
                ""
        );
        UseCaseOutput useCaseOutput = new UseCaseOutput();
        listCourseUseCase.execute(useCaseInput, useCaseOutput);
        if(useCaseOutput.isSuccess()) {
            request.setAttribute("courseList", useCaseOutput.getCourses());
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(useCaseOutput.getMessage());
        }
        if(request.getParameter("selectCourse") != null){
            int selectId = Integer.parseInt(request.getParameter("selectCourse"));
            FindCourseUseCase findCourseUseCase = new FindCourseUseCase();
            findCourseUseCase.setCourseDao(new MySQLCourseDaoImplement());
            useCaseInput.setId(selectId);
            findCourseUseCase.execute(useCaseInput, useCaseOutput);
            request.setAttribute("selectCourse", useCaseOutput.getCourse());
            String[] memberString = useCaseOutput.getCourse().getMember().split("/");
            for(String member: memberString){
                if(memberOption.get(member) != null){
                    memberOption.put(member, 1);
                }
            }
            request.setAttribute("memberOption", memberOption);
            request.setAttribute("id", selectId);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
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
        EditCourseUseCase editCourseUseCase = new EditCourseUseCase();
        editCourseUseCase.setCourseDao(new MySQLCourseDaoImplement());
        UseCaseInput useCaseInput = new UseCaseInput(id, name, content, memberString, price, notice, remark);
        UseCaseOutput useCaseOutput = new UseCaseOutput();
        editCourseUseCase.execute(useCaseInput, useCaseOutput);
        if(useCaseOutput.isSuccess())
            response.sendRedirect("/Edit");
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(useCaseOutput.getMessage());
        }
    }
}
