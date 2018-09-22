package com.cn.erp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 使用单位
 * @author wmc
 * @email 18838988676@gmail.com
 * @date 2018-08-19 18:12:46
 */
public class TestuserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		private String id;
	/**
	 * 单位名称
	 */
	private String name;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 邮政编码
	 */
	private Integer postcode;
	/**
	 * 手机
	 */
	private String phone;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 开户银行id
	 */
	private Integer bankid;
	/**
	 * 银行账号
	 */
	private String bankaccount;
	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 设置：主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：单位名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：单位名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}
	/**
	 * 获取：邮政编码
	 */
	public Integer getPostcode() {
		return postcode;
	}
	/**
	 * 设置：手机
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：传真
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * 获取：传真
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：开户银行id
	 */
	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}
	/**
	 * 获取：开户银行id
	 */
	public Integer getBankid() {
		return bankid;
	}
	/**
	 * 设置：银行账号
	 */
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	/**
	 * 获取：银行账号
	 */
	public String getBankaccount() {
		return bankaccount;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
}
