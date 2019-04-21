package servlet;

import dao.MySQLCourseDaoImplement;
import usecase.edit.EditUseCaseImplement;
import usecase.edit.EditUseCaseInterface;
import usecase.input.edit.EditInputImplement;
import usecase.input.edit.EditInputInterface;
import usecase.input.list.ListInputImplement;
import usecase.input.list.ListInputInterface;
import usecase.list.ListUseCaseImplement;
import usecase.list.ListUseCaseInterface;
import usecase.output.edit.EditOutputImplement;
import usecase.output.edit.EditOutputInterface;
import usecase.output.list.ListOutputImplement;
import usecase.output.list.ListOutputInterface;

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
        Map<String, Integer> memberOption = new HashMap<>();
        String[] option = {"大一", "大二", "大三", "大四", "碩一", "碩二"};
        for(String str: option){
            memberOption.put(str, 0);
        }
        ListUseCaseInterface listUseCase = new ListUseCaseImplement();
        listUseCase.setRepository(new MySQLCourseDaoImplement());
        ListInputInterface input = new ListInputImplement();
        ListOutputInterface output = new ListOutputImplement();
        listUseCase.execute(input, output);
        if(output.isSuccess()) {
            request.setAttribute("courseList", output.getCourses());
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(output.getMessage());
        }
        if(request.getParameter("selectCourse") != null){
            int selectId = Integer.parseInt(request.getParameter("selectCourse"));
            request.setAttribute("selectCourse", output.getCourseById(selectId));
            String[] memberString = output.getCourseById(selectId).getMember().split("/");
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
        EditUseCaseInterface editUseCase = new EditUseCaseImplement();
        editUseCase.setRepository(new MySQLCourseDaoImplement());
        EditInputInterface input = new EditInputImplement(
                id,
                name,
                content,
                memberString,
                price,
                notice,
                remark
        );
        EditOutputInterface output = new EditOutputImplement();
        editUseCase.execute(input, output);
        if(output.isSuccess())
            response.sendRedirect("/Edit");
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
