package com.cn.erp.testredis.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.erp.testredis.dao.DepartmentDao;
import com.cn.erp.testredis.entity.DepartmentVO;

@Service("departmentService")
public class DepartmentServiceImpl{

  	@Autowired
    private DepartmentDao departmentDao;
	

	 /**
     * 列表
     */
   public List<DepartmentVO> list(Map<String, Object> params){
  		return departmentDao.list(params);
  	}
  	
  	
  	 /**
     * 信息
     */
  	public DepartmentVO selectById(String id) {
		return departmentDao.selectById(id);
	}
	
	
	/**
     * 保存
     */
	public Integer insert(DepartmentVO departmentVO) {
		return departmentDao.insert(departmentVO);
	}
	
	 /**
     * 修改
     */
	public Integer updateById(DepartmentVO departmentVO) {
		return departmentDao.updateById(departmentVO);
	}
	
	 /**
     * 删除单个
     */
	public Integer deleteById(Integer id) {
		return  departmentDao.deleteById(id);
	}
	
	/**
     * 删除多个
     */
	public Integer deleteByIds(List<String> ids) {
		return  departmentDao.deleteByIds(ids);
	}
	
	

}
