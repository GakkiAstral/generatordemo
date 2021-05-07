package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * 删除数据
 */
public class DeleteUsersByIdTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        usersMapper.deleteByPrimaryKey(13);
        sqlSession.commit();
    }
}
