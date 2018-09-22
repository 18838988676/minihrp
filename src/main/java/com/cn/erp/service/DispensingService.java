package com.cn.erp.service;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.erp.dao.DispensingDao;
import com.cn.erp.entity.DispensingEntity;


@Service
public class DispensingService {
	@Autowired
	private DispensingDao dispensingDao;

	
	public DispensingEntity findall(String id) {
		return dispensingDao.findall("1");
	}
	
	
	@Transactional
	public void inser(){
		UUID uuid=	UUID.randomUUID();
		
		dispensingDao.insert(UUID.randomUUID().toString(), 777);
		dispensingDao.insert(UUID.randomUUID().toString(), 78888);
	}

}
