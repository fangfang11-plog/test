package com.fang.service;

import com.fang.mapper.UserMapper;
import com.fang.pojo.User;
import com.fang.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSSqlSessionFactory();

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User select(String username,String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }

    public boolean register(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userCheck = mapper.selectByName(user.getUsername());
        if (userCheck == null) {
            System.out.println("success");
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return userCheck == null;
    }

    /**
     * 根据姓名查询
     * @param username
     * @return
     */
    public User selectByUsername(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectByName(username);
    }
}
