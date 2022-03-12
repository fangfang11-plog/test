package com.fang.mapper;

import com.fang.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     *
     * @param user
     * @return
     */
    @Select("insert into tb_user(username,password) value (#{username},#{password})")
    User add(User user);

    /**
     *
     * @param username
     * @return
     */
    @Select("select * from tb_user where username = #{username}")
    User selectByName(@Param("username")String username);

    /**
     *
     * @return
     */
    @Select("select * from tb_user")
    List<User> selectAll();

}
