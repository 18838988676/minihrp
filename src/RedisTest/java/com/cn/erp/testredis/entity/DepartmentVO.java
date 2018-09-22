package com.cn.erp.testredis.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 科室
 * @author wmc
 * @email 18838988676@gmail.com
 * @date 2018-09-19 19:23:40
 */
public class DepartmentVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		private Integer id;
	/**
	 * 编号
	 */
	private String departmentcode;
	/**
	 * 名称
	 */
	private String departmentname;
	/**
	 * 拼音简码
	 */
	private String pinyincode;
	/**
	 * 五笔简码
	 */
	private String wubicode;
	/**
	 * 挂号金额
	 */
	private BigDecimal registersum;
	/**
	 * 科室位置
	 */
	private String site;
	/**
	 * 是否允许挂号
	 */
	private Integer isregister;
	/**
	 * 是否有效
	 */
	private Integer isvalid;
	/**
	 * 备注
	 */
	private String note;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：编号
	 */
	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}
	/**
	 * 获取：编号
	 */
	public String getDepartmentcode() {
		return departmentcode;
	}
	/**
	 * 设置：名称
	 */
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	/**
	 * 获取：名称
	 */
	public String getDepartmentname() {
		return departmentname;
	}
	/**
	 * 设置：拼音简码
	 */
	public void setPinyincode(String pinyincode) {
		this.pinyincode = pinyincode;
	}
	/**
	 * 获取：拼音简码
	 */
	public String getPinyincode() {
		return pinyincode;
	}
	/**
	 * 设置：五笔简码
	 */
	public void setWubicode(String wubicode) {
		this.wubicode = wubicode;
	}
	/**
	 * 获取：五笔简码
	 */
	public String getWubicode() {
		return wubicode;
	}
	/**
	 * 设置：挂号金额
	 */
	public void setRegistersum(BigDecimal registersum) {
		this.registersum = registersum;
	}
	/**
	 * 获取：挂号金额
	 */
	public BigDecimal getRegistersum() {
		return registersum;
	}
	/**
	 * 设置：科室位置
	 */
	public void setSite(String site) {
		this.site = site;
	}
	/**
	 * 获取：科室位置
	 */
	public String getSite() {
		return site;
	}
	/**
	 * 设置：是否允许挂号
	 */
	public void setIsregister(Integer isregister) {
		this.isregister = isregister;
	}
	/**
	 * 获取：是否允许挂号
	 */
	public Integer getIsregister() {
		return isregister;
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
	/**
	 * 设置：备注
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：备注
	 */
	public String getNote() {
		return note;
	}
	@Override
	public String toString() {
		return "DepartmentVO [id=" + id + ", departmentcode=" + departmentcode
				+ ", departmentname=" + departmentname + ", pinyincode="
				+ pinyincode + ", wubicode=" + wubicode + ", registersum="
				+ registersum + ", site=" + site + ", isregister=" + isregister
				+ ", isvalid=" + isvalid + ", note=" + note + "]";
	}
	
	
}
