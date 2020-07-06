package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.Info;
import com.xjtuse.summerproject.controllerEntity.RecentInfo;
import com.xjtuse.summerproject.controllerEntity.RecentInfoResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecentInfoController {

    @RequestMapping("/RecentInfo")
    public @ResponseBody
    RecentInfoResponse recentInfo(@RequestBody Info info) {
        RecentInfoResponse recentInfoResponse = new RecentInfoResponse();
        System.out.println("info = " + info);
        //模拟查数据库
        recentInfoResponse.setId("recent_info");
        RecentInfo recentInfo1 = new RecentInfo();
        recentInfo1.setId("info_id1");
        recentInfo1.setValue("This is info_id1");
        recentInfo1.setInfo_id_path("This is info_id_path1");
        recentInfo1.setCourse("高等数学");
        recentInfo1.setDatetime("2020-7-3");
        RecentInfo recentInfo2 = new RecentInfo();
        recentInfo2.setId("info_id2");
        recentInfo2.setValue("This is info_id2");
        recentInfo2.setInfo_id_path("This is info_id_path2");
        recentInfo2.setCourse("线性代数");
        recentInfo2.setDatetime("2020-7-4");
        List<RecentInfo> list = new ArrayList<RecentInfo>();
        list.add(recentInfo1);
        list.add(recentInfo2);
        recentInfoResponse.setValue(list);
        return recentInfoResponse;
    }
}
