package com.fang.web.ServletDeal;

import com.fang.pojo.User;
import com.fang.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收用户名和密码
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        String checkCode = req.getParameter("checkCode");

        HttpSession session = req.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        if (!checkCodeGen.equals(checkCode)) {
            req.setAttribute("register_msg","验证码错误");
            req.getRequestDispatcher("/LoginAndRegister/register.html").forward(req,resp);
            return;
        }


        boolean flag = service.register(user);
        if (flag) {
            req.setAttribute("register_msg","注册成功,请登录");
            req.getRequestDispatcher("/LoginAndRegister/login.jsp").forward(req,resp);

        } else {
            req.setAttribute("register_msg","用户名已存在");
            req.getRequestDispatcher("/LoginAndRegister/register.html").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}