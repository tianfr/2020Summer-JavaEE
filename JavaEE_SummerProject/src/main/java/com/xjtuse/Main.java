package com.xjtuse;

import com.xjtuse.dao.mapper.StudentMapper;
import com.xjtuse.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student("stu20200102","tianfr","18", "male", "747458467@qq.com",  "SOFT73","calmcat1", "calmcat1", "2020-01-01");
            mapper.insert(student);


            } finally {
            sqlSession.close();
        }

    }
}
