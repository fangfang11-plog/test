package com.fang.web.ServletDeal;

import com.fang.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectUserServlet")
public class SelectUserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户名
        String username = request.getParameter("username");
        System.out.println("用户名" + username);
        //2.调用service查询User对象
        boolean flag = false;
        if (userService.selectByUsername(username) != null) {
            //用户名存在
            flag = true;
        } else {
            flag = false;
        }
        response.getWriter().write("" + flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
