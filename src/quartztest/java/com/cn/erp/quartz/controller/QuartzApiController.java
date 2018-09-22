package com.cn.erp.quartz.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.erp.quartz.config.QuartzScheduler;

/**
 * 这里并没有采用restful风格 只是简单封装了一下api
 *   封装API 
这里封装的API主要是为了方便动态管理执行任务，当然依赖这些接口也可以做一个界面来更直观的操作管理任务，这个就不再赘述。
 * @author yvan
 *
 */
@RestController
@RequestMapping("/quartz")
public class QuartzApiController {
    @Autowired
    private QuartzScheduler quartzScheduler;

    @RequestMapping("/start")
    public void startQuartzJob() {
        try {
            quartzScheduler.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/info")
    public String getQuartzJob(String name, String group) {
        String info = null;
        try {
            info = quartzScheduler.getJobInfo(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }

    @RequestMapping("/modify")
    public boolean modifyQuartzJob(String name, String group, String time) {
        boolean flag = true;
        try {
            flag = quartzScheduler.modifyJob(name, group, time);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "/pause")
    public void pauseQuartzJob(String name, String group) {
        try {
            quartzScheduler.pauseJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() {
        try {
            quartzScheduler.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/delete")
    public void deleteJob(String name, String group) {
        try {
            quartzScheduler.deleteJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/resumeJob")
    public void resumeJob(String name, String group) {
        try {
            quartzScheduler.resumeJob(name,group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    
    
    
}