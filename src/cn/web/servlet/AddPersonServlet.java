package cn.web.servlet;

import cn.domain.I_person;
import cn.service.PersonService;
import cn.service.impl.PersonServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ProjectName: basic_code
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 晴天
 * @Date: 2019/12/22 22:01
 * @Version: 1.0
 */
@WebServlet("/addPersonServlet")
public class AddPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        I_person person = new I_person();
        try {
            BeanUtils.populate(person,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用Service保存
        PersonService Pservice = new PersonServiceImpl();
        Pservice.addPerson(person);
        //5.跳转到PersonListServlet
        response.sendRedirect(request.getContextPath()+"/findPersonByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
