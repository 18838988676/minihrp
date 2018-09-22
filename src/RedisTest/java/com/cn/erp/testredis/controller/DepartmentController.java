package com.cn.erp.testredis.controller;

import java.util.List;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cn.erp.testredis.entity.DepartmentVO;
import com.cn.erp.testredis.service.impl.DepartmentServiceImpl;

/**
 * 科室
 * @author wmc
 * @email 18838988676@gmail.com
 * @date 2018-09-19 19:23:40
 */
 
@Controller
@RequestMapping("/departmentController")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public List<DepartmentVO> list(@RequestParam Map<String, Object> params){
          List<DepartmentVO> departments = departmentServiceImpl.list(params);
          for (DepartmentVO departmentVO : departments) {
			System.out.println(departmentVO);
		}
        return departments;
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public DepartmentVO info(@PathVariable("id") String id){
			DepartmentVO department = departmentServiceImpl.selectById(id);
        return department;
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public String save(@RequestBody DepartmentVO department){
		Integer num=departmentServiceImpl.insert(department);
        return "success";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public String update(@RequestBody DepartmentVO department){
		Integer num=departmentServiceImpl.updateById(department);
        return "success";
    }

	 /**
     * 删除单个
     */
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
		Integer num=departmentServiceImpl.deleteById(id);
        return "success";
    }

    /**
     * 删除多个
     */
    @ResponseBody
    @RequestMapping("/deletes")
    public String deletes(@RequestBody String[] ids){
		Integer num=departmentServiceImpl.deleteByIds(Arrays.asList(ids));
        return "success";
    }
}
