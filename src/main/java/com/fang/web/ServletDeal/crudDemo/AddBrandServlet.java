package com.fang.web.ServletDeal.crudDemo;

import com.alibaba.fastjson.JSON;
import com.fang.pojo.Brand;
import com.fang.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addBrandServlet")
public class AddBrandServlet extends HttpServlet {
    private BrandServiceImpl service = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        Brand brand = new Brand();
//        brand.setBrandName(request.getParameter("brandName"));
//        brand.setCompanyName(request.getParameter("companyName"));
//        brand.setOrdered(Integer.parseInt(request.getParameter("ordered")));
//        brand.setDescription(request.getParameter("description"));
//        brand.setStatus(Integer.parseInt(request.getParameter("status")));
//
//        service.add(brand);
////        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
//        response.sendRedirect("/brand/brand.html");
        //读取请求头,不可以用getParammeter
        BufferedReader br = request.getReader();
        String Params = br.readLine();
        Brand brand = JSON.parseObject(Params,Brand.class);
        service.add(brand);
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
