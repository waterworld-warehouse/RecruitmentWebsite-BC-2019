package cn.web.servlet;

import cn.domain.I_person;
import cn.domain.PersonPageBean;
import cn.service.PersonService;
import cn.service.impl.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ProjectName: basic_code
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 晴天
 * @Date: 2019/12/24 9:08
 * @Version: 1.0
 */
@WebServlet("/findPersonByPageServlet")
public class FindPersonByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = request.getParameter("currentPage");   //当前页码
        String rows = request.getParameter("rows");                 //每页显示条数

        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "5";
        }

        //获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();
        //2.调用service查询
        PersonService pService = new PersonServiceImpl();
        PersonPageBean<I_person> pb = pService.findPersonByPage(currentPage,rows,condition);


        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.转发到job_hunting.jsp
        request.getRequestDispatcher("/job_hunting.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
