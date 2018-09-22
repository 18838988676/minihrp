package com.cn.erp.testredis.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.cn.erp.testredis.entity.DepartmentVO;

/**
 * 科室
 * 
 * @author wmc
 * @email 18838988676@gmail.com
 * @date 2018-09-19 19:23:40
 */
@Mapper
public interface DepartmentDao {
	
	List<DepartmentVO> list(Map<String, Object> params);

	DepartmentVO selectById(String id);

	Integer deleteById(Integer id);

	Integer updateById(DepartmentVO departmentVO);

	Integer deleteByIds(List<String> asList);

	Integer insert(DepartmentVO departmentVO);
	
}
