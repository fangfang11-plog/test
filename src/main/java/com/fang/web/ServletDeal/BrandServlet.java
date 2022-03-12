package com.fang.web.ServletDeal;


import com.alibaba.fastjson.JSON;
import com.fang.pojo.Brand;
import com.fang.pojo.PageBean;
import com.fang.service.BrandService;
import com.fang.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brandServlet/*")
public class BrandServlet extends BaseServlet{
    private BrandService service = new BrandServiceImpl();

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用BrandService完成查询
        List<Brand> brands = service.selectAll();

        //2.将集合转换为JSON数据,序列化
        String jsonString = JSON.toJSONString(brands);

        //3.响应数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询页数
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);


        //1.调用BrandService完成查询
        PageBean<Brand> pageBean= service.selectByPage(currentPage,pageSize);

        //2.将集合转换为JSON数据,序列化
        String jsonString = JSON.toJSONString(pageBean);

        //3.响应数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String Params = br.readLine();
        Brand brand = JSON.parseObject(Params,Brand.class);
        service.add(brand);
        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String Params = br.readLine();
        int[] ids = JSON.parseObject(Params,int[].class);
        service.deleteByIds(ids);
        resp.getWriter().write("success");
    }

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询页数
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        BufferedReader br = req.getReader();
        String Params = br.readLine();
        Brand brand = JSON.parseObject(Params,Brand.class);

        PageBean<Brand> pageBean = service.selectByPageAndCondition(currentPage,pageSize,brand);

        //2.将集合转换为JSON数据,序列化
        String jsonString = JSON.toJSONString(pageBean);

        //3.响应数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);

    }

}
