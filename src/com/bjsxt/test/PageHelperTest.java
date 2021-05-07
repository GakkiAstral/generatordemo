package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.pojo.UsersExample;
import com.bjsxt.utils.MybatisUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * PageHelper分页测试
 */
public class PageHelperTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        UsersExample usersExample = new UsersExample();
        PageHelper.startPage(2,2);
        List<Users> list = usersMapper.selectByExample(usersExample);
        list.forEach(System.out::println);
        PageInfo<Users> pageInfo = new PageInfo<>(list);

        //获取结果集
        List<Users> result = pageInfo.getList();
        result.forEach(System.out::println);
        //获取总条数
        System.out.println("总条数："+pageInfo.getTotal());
        //获取总页数
        System.out.println("总页数"+pageInfo.getPages());
        //获取当前页
        System.out.println("当前页"+pageInfo.getPageNum());
        //获取每页显示的条数
        System.out.println("每页条数"+pageInfo.getSize());
     }
}
