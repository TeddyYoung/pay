package com.aotu.entity;

/**
 * 品牌信息
 * @author zhoujj
 *
 */
public class Brand extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String brandNo;//品牌编号
	private String brandName;//品牌名称
	private String fullName;//公司名称
	private String address;//公司地址
	private String president;//法人代表
	private String phone;//联系电话
	private String status;//状态(1-正常;2-注销)
	
	public String getBrandNo() {
		return brandNo;
	}
	public void setBrandNo(String brandNo) {
		this.brandNo = brandNo;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPresident() {
		return president;
	}
	public void setPresident(String president) {
		this.president = president;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
} 
