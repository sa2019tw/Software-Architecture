package servlet;

import dao.MySQLCourseDaoImplement;
import usecase.input.insert.InsertInputImplement;
import usecase.input.insert.InsertInputInterface;
import usecase.insert.InsertUseCaseImplement;
import usecase.insert.InsertUseCaseInterface;
import usecase.output.insert.InsertOutputImplement;
import usecase.output.insert.InsertOutputInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        InsertUseCaseInterface insertUseCase = new InsertUseCaseImplement();
        insertUseCase.setRepository(new MySQLCourseDaoImplement());
        InsertInputInterface input = new InsertInputImplement(
                -1,
                name,
                content,
                memberString,
                price,
                notice,
                remark
        );
        InsertOutputInterface output = new InsertOutputImplement();
        insertUseCase.execute(input, output);
        if(output.isSuccess())
            request.getRequestDispatcher("/WEB-INF/jsp/insert.jsp").forward(request, response);
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            System.out.println(output.getMessage());
        }
    }
}
