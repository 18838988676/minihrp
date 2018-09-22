package com.cn.erp.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 发药
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-08-18 19:59:26
 */
public class DispensingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 收费id
	 */
	private Integer chargeid;
	/**
	 * 发药状态
	 */
	private Integer dispensingstatus;
	/**
	 * 发药时间
	 */
	private Date dispensingtime;
	/**
	 * 是否有效
	 */
	private Integer isvalid;

	/**
	 * 设置：主键
	 */
	
	/**
	 * 获取：主键
	 */
	
	/**
	 * 设置：收费id
	 */
	public void setChargeid(Integer chargeid) {
		this.chargeid = chargeid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：收费id
	 */
	public Integer getChargeid() {
		return chargeid;
	}
	/**
	 * 设置：发药状态
	 */
	public void setDispensingstatus(Integer dispensingstatus) {
		this.dispensingstatus = dispensingstatus;
	}
	/**
	 * 获取：发药状态
	 */
	public Integer getDispensingstatus() {
		return dispensingstatus;
	}
	/**
	 * 设置：发药时间
	 */
	public void setDispensingtime(Date dispensingtime) {
		this.dispensingtime = dispensingtime;
	}
	/**
	 * 获取：发药时间
	 */
	public Date getDispensingtime() {
		return dispensingtime;
	}
	/**
	 * 设置：是否有效
	 */
	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}
	/**
	 * 获取：是否有效
	 */
	public Integer getIsvalid() {
		return isvalid;
	}
}
