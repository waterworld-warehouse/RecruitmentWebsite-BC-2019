package cn.web.servlet;

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
 * @Date: 2019/12/23 10:37
 * @Version: 1.0
 */
@WebServlet("/delPersonServlet")
public class DelPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        PersonService pService = new PersonServiceImpl();
        pService.deletePerson(id);
        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findPersonByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
