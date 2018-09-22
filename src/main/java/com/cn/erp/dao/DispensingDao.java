package com.cn.erp.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cn.erp.entity.DispensingEntity;

@Mapper
public interface DispensingDao {
	
//	@Select("select * from dispensing where id=#{id}")
	DispensingEntity findall(@Param("id") String id);
	
	//@Insert("insert into dispensing(id,chargeid) values(#{id},#{chargeid})")
	int insert(@Param("id") String id,@Param("chargeid") Integer chargeid);

}
