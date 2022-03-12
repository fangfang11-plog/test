package com.fang.mapper;

import com.fang.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加操作
     * @param brand
     */
    @Insert("insert into tb_brand values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void add(Brand brand);

    /**
     * 查询所有
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id = #{id} ")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    /**
     * 修改操作
     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered=#{ordered},description=#{description},status=#{status} where id = #{id} ")
    void update(Brand brand);

    @Delete("delete from tb_brand where id = #{id}")
    void delete(int id);

    /**
     * 删除数据
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);


    /**
     *
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_brand limit #{begin},#{size} ")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);


    /**
     *
     * @return
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();


    /**
     *
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    @ResultMap("brandResultMap")
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     *
     * @param brand
     * @return
     */
    int selectTotalCountByCondition(Brand brand);

}
