package com.aotu.entity;

import java.math.BigDecimal;

/**
 * 地区基础信息
 * @author zhoujj
 *
 */
public class Area extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String fullName;//地区全称
	private String name;//地区名称
	private String treePath;//地区树编号
	private String parent;//上级地区编号
	private String code;//地区编号
	private String zipCode;//邮政编码
	private String telCode;//电话编码
	private BigDecimal locationx;//X-坐标
	private BigDecimal locationy;//Y-坐标
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTreePath() {
		return treePath;
	}
	
	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	
	public String getParent() {
		return parent;
	}
	
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getTelCode() {
		return telCode;
	}
	
	public void setTelCode(String telCode) {
		this.telCode = telCode;
	}
	
	public BigDecimal getLocationx() {
		return locationx;
	}
	
	public void setLocationx(BigDecimal locationx) {
		this.locationx = locationx;
	}
	
	public BigDecimal getLocationy() {
		return locationy;
	}
	
	public void setLocationy(BigDecimal locationy) {
		this.locationy = locationy;
	}
	
} 
