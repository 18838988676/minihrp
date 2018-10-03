package com.cn.erp.rabbitmqentity;

import lombok.Data;
import java.io.Serializable;
 
/**
 * Order
 * @author zhuzhe
 * @date 2018/6/7 9:49
 * @email 1529949535@qq.com
 */
@Data
public class Order implements Serializable{
 
    private Long id;
 
    private Double price;
 
    private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + ", remark=" + remark + "]";
	}
    
    
}
