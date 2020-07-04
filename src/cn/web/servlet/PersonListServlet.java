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
import java.util.List;

/**
 * @ProjectName: basic_code
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 晴天
 * @Date: 2019/12/22 22:08
 * @Version: 1.0
 */
@WebServlet("/personListServlet")
public class PersonListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用PersonService完成查询
        PersonService Pservice = new PersonServiceImpl();
        List<I_person> persons = Pservice.findAll();
        //2.将list存入request域
        request.setAttribute("persons",persons);
        //3.转发到job_hunting.jsp页面
        request.getRequestDispatcher("/job_hunting.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
