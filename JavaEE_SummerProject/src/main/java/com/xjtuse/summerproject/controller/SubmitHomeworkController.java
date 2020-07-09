package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.SubmitHomeworkInfo;
import com.xjtuse.summerproject.controllerEntity.SubmitHomeworkResponse;
import com.xjtuse.summerproject.controllerEntity.UpdateHomeworkInfo;
import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.CourseHomework;
import com.xjtuse.summerproject.mapper.CourseMapper;
import com.xjtuse.summerproject.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

@Controller
public class SubmitHomeworkController {
    @PostMapping("/SubmitHomework")
    public @ResponseBody
    SubmitHomeworkResponse submitHomework(@RequestBody SubmitHomeworkInfo submitHomeworkInfo, HttpSession session) throws IOException {
        SubmitHomeworkResponse submitHomeworkResponse = new SubmitHomeworkResponse();
        UpdateHomeworkInfo updateHomeworkInfo = new UpdateHomeworkInfo();
        updateHomeworkInfo.setStudent_id(session.getAttribute("id").toString());
        updateHomeworkInfo.setHomework_file_path(session.getAttribute("homework_file_path").toString());
        updateHomeworkInfo.setHomework_file_name(session.getAttribute("homework_file_name").toString());
        updateHomeworkInfo.setCourse_id(submitHomeworkInfo.getCourse_id().toString());
        updateHomeworkInfo.setHomework_id(submitHomeworkInfo.getHomework_id().toString());
        updateHomeworkInfo.setContent(submitHomeworkInfo.getHomework_content().toString());
        String time = new Date(System.currentTimeMillis()).toString();
        updateHomeworkInfo.setInsert_date(time);


        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        courseMapper.updateHomework(updateHomeworkInfo);
        sqlSession.commit();
        sqlSession.close();
        in.close();
        submitHomeworkResponse.setSuccess_value("1");
        submitHomeworkResponse.setDatetime(time);
        submitHomeworkResponse.setFail_content("上传成功");
        return submitHomeworkResponse;
    }
}
