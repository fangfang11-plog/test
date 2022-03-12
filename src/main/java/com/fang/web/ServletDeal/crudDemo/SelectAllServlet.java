package com.fang.web.ServletDeal.crudDemo;

import com.alibaba.fastjson.JSON;
import com.fang.pojo.Brand;
import com.fang.service.BrandService;
import com.fang.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用BrandService完成查询
        List<Brand> brands = service.selectAll();

        //2.将集合转换为JSON数据,序列化
        String jsonString = JSON.toJSONString(brands);

        //3.响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
