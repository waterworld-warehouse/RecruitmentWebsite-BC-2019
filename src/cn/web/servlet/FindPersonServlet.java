package cn.web.servlet;

import cn.domain.I_person;
import cn.service.PersonService;
import cn.service.impl.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: basic_code
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 晴天
 * @Date: 2019/12/23 16:41
 * @Version: 1.0
 */
@WebServlet("/findPersonServlet")
public class FindPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用Service查询
        PersonService pService = new PersonServiceImpl();
        I_person person = pService.findPersonById(id);
        //3.将person存入request中
        request.setAttribute("person",person);
        //4.转发到job_update.jsp
        request.getRequestDispatcher("/job_update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
