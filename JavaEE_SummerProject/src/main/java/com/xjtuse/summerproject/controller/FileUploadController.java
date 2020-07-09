package com.xjtuse.summerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

@Controller
public class FileUploadController {

    @ResponseBody
    @PostMapping("/FileUpload")
    public String fileupload2(HttpServletRequest request, @RequestParam("file") MultipartFile file, HttpSession session) throws Exception {
        System.out.println("SpringMVC文件上传...");
        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/homework");
        File file1 = new File(path);
        if(file1.exists()) {
            //创建文件夹
            file1.mkdirs();
        }
        //获取上传文件的名称
        String filename = file.getOriginalFilename();
        //把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        file.transferTo(new File(path, filename));
        session.setAttribute("homework_file_path", path+"/"+filename);
        session.setAttribute("homework_file_name", filename.split("_")[1]);
        return "success";
    }
}
