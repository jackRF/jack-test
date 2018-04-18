package com.jack.test.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="test_product")
@Entity
public class Product {
	@Id
	@Column
	private Long id;
	/**
	 * 产品编码
	 */
	@Column
	private String code;
	/**
	 * 产品名称
	 */
	@Column
	private String name;
	/**
	 * 价格
	 */
	@Column
	private BigDecimal price;
	/**
	 * 标记
	 */
	@Column
	private Long flag;
	@Column(name="CREATE_TIME")
	private Date createTime;
	@Column(name="MODIFY_TIME")
	private Date modifyTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getFlag() {
		return flag;
	}
	public void setFlag(Long flag) {
		this.flag = flag;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
