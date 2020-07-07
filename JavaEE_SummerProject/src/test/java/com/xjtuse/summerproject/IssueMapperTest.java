package com.xjtuse.summerproject;

import com.xjtuse.summerproject.controllerEntity.Issue;
import com.xjtuse.summerproject.entity.Temp;
import com.xjtuse.summerproject.mapper.IssueMapper;
import com.xjtuse.summerproject.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class IssueMapperTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IssueMapper issueMapper;

    @Before
    public void init() throws Exception{

        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        issueMapper = sqlSession.getMapper(IssueMapper.class);
    }

    @After
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindIssue() throws Exception{
        //5.执行deleteStudent方法
        Temp temp = new Temp();
        temp.setCourse_id("coursedemo001");
        temp.setAnnouncement_id("tch20200101_content_announcement001");
        Issue issue = issueMapper.findIssue(temp);
        System.out.println("issue = " + issue);
    }

}
