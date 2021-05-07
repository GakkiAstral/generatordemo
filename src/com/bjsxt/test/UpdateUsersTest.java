package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * 更新用户
 */
public class UpdateUsersTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("David");
        users.setUsersex("male");
        users.setUserid(13);
        usersMapper.updateByPrimaryKey(users);
        sqlSession.commit();
    }
}
