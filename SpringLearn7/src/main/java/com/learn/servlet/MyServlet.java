package com.learn.servlet;

import com.learn.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * web.xml
 * <servlet></servlet>
 * <servlet-mapping>
 *     <url-partten>/myservlet</url-partten>
 * </servlet-mapping>
 */
@WebServlet(value = "/myServlet")
public class MyServlet extends HttpServlet {
    /*  @Autowired
      private UserService userService;*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //从servletContxt作用域中获取spring容器对象
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        UserService userService = webApplicationContext.getBean(UserService.class);
        userService.updateUser();
     /*   ApplicationContext context =new ClassPathXmlApplicationContext("bean.xml");*/
    }
}
