package com.fang.web.ServletDeal;

import com.fang.pojo.User;
import com.fang.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * urlPattern:目录匹配
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收表单数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        //进行数据库查询
        User user = service.select(username,password);
        if (user != null) {
            //传递session
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
        //记住用户登录状态，使用cookie
            if ("1".equals(remember)) {
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                c_username.setMaxAge(60*60*60*7);
                c_password.setMaxAge(60*60*60*7);
                resp.addCookie(c_password);
                resp.addCookie(c_username);
            }
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/selectAllServlet");
        }else {
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/LoginAndRegister/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}