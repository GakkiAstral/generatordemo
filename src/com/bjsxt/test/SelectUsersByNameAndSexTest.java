package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.pojo.UsersExample;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 根据用户姓名与性别查询用户
 */
public class SelectUsersByNameAndSexTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo("bjsxt");
        criteria.andUsersexEqualTo("male");
        List<Users> list = usersMapper.selectByExample(usersExample);
        list.forEach(System.out::println);
    }
}
