package com.fang.service;

import com.fang.pojo.Brand;
import com.fang.pojo.PageBean;

import java.util.List;

public interface BrandService  {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();


    /**
     * 添加品牌
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Brand selectById(int id);


    /**
     * 更改数据
     * @param brand
     */
    void update(Brand brand);

    /**
     * 根据id删除
     * @param id
     */
    void delete(int id);

    /**
     *
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);



}
